package com.epam.jpamodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpamodule.model.Unit;

@Repository
public class UnitDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UnitDAO() {
		super();
	}

	@Transactional
	public void insertUnits(List<Unit> units) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			for (Unit unit : units) {
				entityManager.persist(unit);
			}
			entityManager.flush();
		} finally {
			entityManager.close();
		}
	}

	public int save(Unit unit) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (null == unit.getId()) {
				entityManager.persist(unit);
			} else {
				entityManager.merge(unit);
			}
			id = unit.getId();
			entityManager.flush();
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

	public void remove(int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Unit unit = entityManager.find(Unit.class, id);
			entityManager.remove(unit);
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
