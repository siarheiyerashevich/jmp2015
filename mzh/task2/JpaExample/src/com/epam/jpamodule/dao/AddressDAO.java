package com.epam.jpamodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epam.jpamodule.model.Address;
import com.epam.jpamodule.util.JpaUtil;

public class AddressDAO {

	private EntityManagerFactory entityManagerFactory;

	public AddressDAO() {
		entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
	}

	public void add(Address address) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(address);
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	public Address get(int id) {
		Address address = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		address = entityManager.find(Address.class, id);
		entityManager.close();
		return address;
	}
}
