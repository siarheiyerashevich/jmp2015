package com.epam.jpamodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.util.JpaUtil;

public class EmployeeDAO {

	private EntityManagerFactory entityManagerFactory;

	public EmployeeDAO() {
		entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
	}

	public int save(Employee employee) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (0 == employee.getId()) {
				entityManager.persist(employee);
			} else {
				entityManager.merge(employee);
			}
			id = employee.getId();
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		return id;
	}

	public Employee get(int id) {
		Employee employee = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		employee = entityManager.find(Employee.class, id);
		entityManager.close();
		return employee;
	}

	public void remove(int id) {
		Employee employee = get(id);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
