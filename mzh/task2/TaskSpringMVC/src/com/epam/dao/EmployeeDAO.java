package com.epam.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.epam.model.Address;
import com.epam.model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EmployeeDAO() {
		super();
	}

	public Employee get(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
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

	public List<Employee> getEmployees() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void save(Employee employee) throws Exception {
		save(employee, false);
	}

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

	private void save(Employee employee, final boolean isThrow) throws Exception {
		if (isThrow) {
			throw new RuntimeException();
		}
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			//entityTransaction.begin();
			if (null == employee.getId()) {
				entityManager.persist(employee);
			} else {
				entityManager.merge(employee);
			}
			entityManager.flush();
			//entityTransaction.commit();
		} catch (Exception exception) {
			//entityTransaction.rollback();
			throw exception;
		} finally {
			entityManager.close();
		}
	}
}