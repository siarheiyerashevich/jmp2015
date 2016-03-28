package com.epam.jpamodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epam.jpamodule.model.Unit;
import com.epam.jpamodule.util.JpaUtil;

public class UnitDAO {

	private EntityManagerFactory entityManagerFactory;

	public UnitDAO() {
		entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
	}

	public int save(Unit unit) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (0 == unit.getId()) {
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

	public void remove(int id) {
		Unit unit = get(id);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.remove(unit);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
