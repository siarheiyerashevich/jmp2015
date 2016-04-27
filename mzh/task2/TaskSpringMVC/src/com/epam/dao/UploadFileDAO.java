package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.epam.model.UploadFile;

@Repository
public class UploadFileDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UploadFileDAO() {
		super();
	}

	public UploadFile get(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UploadFile uploadFile = entityManager.find(UploadFile.class, id);
		entityManager.close();
		return uploadFile;
	}

	public List<UploadFile> getUploadFiles() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UploadFile> criteriaQuery = criteriaBuilder.createQuery(UploadFile.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void save(UploadFile uploadFile) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (null == uploadFile.getId()) {
				entityManager.persist(uploadFile);
			} else {
				entityManager.merge(uploadFile);
			}
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			throw exception;
		} finally {
			entityManager.close();
		}
	}

	public void remove(int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			UploadFile uploadFile = entityManager.find(UploadFile.class, id);
			entityManager.remove(uploadFile);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
			throw exception;
		} finally {
			entityManager.close();
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}