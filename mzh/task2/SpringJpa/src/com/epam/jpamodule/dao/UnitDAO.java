package com.epam.jpamodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpamodule.model.Unit;

@Component
public class UnitDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UnitDAO() {
		super();
	}

	@Transactional
	public void insertUnits(List<Unit> units) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			for (Unit unit : units) {
				entityManager.persist(unit);
			}
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	@Transactional
	public int save(Unit unit) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (null == unit.getId()) {
				entityManager.persist(unit);
			} else {
				entityManager.merge(unit);
			}
			id = unit.getId();
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		return id;
	}

	public Unit get(int id) {
		Unit unit = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		unit = entityManager.find(Unit.class, id);
		entityManager.close();
		return unit;
	}

	@Transactional
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
