package com.epam.jpamodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epam.jpamodule.model.PersonalInfo;
import com.epam.jpamodule.util.JpaUtil;

public class PersonalInfoDAO {

	private EntityManagerFactory entityManagerFactory;

	public PersonalInfoDAO() {
		entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
	}

	public void add(PersonalInfo personalInfo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(personalInfo);
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	public PersonalInfo get(int id) {
		PersonalInfo personalInfo = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		personalInfo = entityManager.find(PersonalInfo.class, id);
		entityManager.close();
		return personalInfo;
	}
}
