package com.epam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.epam.model.Project;

@Repository
public class ProjectDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectDAO() {
		super();
	}

	public Project get(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Project project = entityManager.find(Project.class, id);
		entityManager.close();
		return project;
	}

	public Project getProjectByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		Root<Project> rootProject = criteriaQuery.from(Project.class);
		criteriaQuery.where(criteriaBuilder.equal(rootProject.get("name"), name));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	public List<Project> getProjects() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void save(Project project) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (null == project.getId()) {
				entityManager.persist(project);
			} else {
				entityManager.merge(project);
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
			Project project = entityManager.find(Project.class, id);
			entityManager.remove(project);
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