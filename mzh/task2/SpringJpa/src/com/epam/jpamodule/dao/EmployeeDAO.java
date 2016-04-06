package com.epam.jpamodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpamodule.model.Address;
import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.EmployeeStatus;
import com.epam.jpamodule.model.PersonalInfo;

@Component
public class EmployeeDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EmployeeDAO() {
		super();
	}

	@Transactional
	public void insertEmployees(List<Employee> employees) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			for (Employee employee : employees) {
				entityManager.persist(employee);
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
	public int save(Employee employee, final boolean isThrow) {
		if (isThrow) {
			throw new RuntimeException();
		}
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (null == employee.getId()) {
				entityManager.persist(employee);
			} else {
				entityManager.merge(employee);
			}

			entityManager.flush();
			id = employee.getId();
		} finally {
			entityManager.close();
		}
		return id;
	}

	@Transactional
	public int save(Employee employee) {
		return save(employee, false);
	}

	public Employee get(int id) {
		Employee employee = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		employee = entityManager.find(Employee.class, id);
		entityManager.close();
		return employee;
	}

	public Employee getByLastName(String lastName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> rootEmployee = criteriaQuery.from(Employee.class);
		criteriaQuery.where(criteriaBuilder.equal(rootEmployee.get("lastName"), lastName));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	public Employee getByCountry(String country) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> rootEmployee = criteriaQuery.from(Employee.class);
		Join<Employee, Address> joinAddress = rootEmployee.join("address");
		criteriaQuery.where(criteriaBuilder.equal(joinAddress.get("country"), country));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	@Transactional
	public void remove(int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Employee employee = entityManager.find(Employee.class, id);
			entityManager.remove(employee);
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
