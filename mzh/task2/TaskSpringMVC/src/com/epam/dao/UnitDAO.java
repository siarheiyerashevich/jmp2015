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
import com.epam.model.Unit;

@Repository
public class UnitDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UnitDAO() {
		super();
	}

	public Unit get(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Unit unit = entityManager.find(Unit.class, id);
		entityManager.close();
		return unit;
	}

	public Unit getUnitByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Unit> criteriaQuery = criteriaBuilder.createQuery(Unit.class);
		Root<Unit> rootUnit = criteriaQuery.from(Unit.class);
		criteriaQuery.where(criteriaBuilder.equal(rootUnit.get("name"), name));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	public List<Unit> getUnits() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Unit> criteriaQuery = criteriaBuilder.createQuery(Unit.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void save(Unit unit) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (null == unit.getId()) {
				entityManager.persist(unit);
			} else {
				entityManager.merge(unit);
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
			Unit unit = entityManager.find(Unit.class, id);
			entityManager.remove(unit);
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