package com.epam.jpamodule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.util.JpaUtil;

public class ProjectDAO {

	private EntityManagerFactory entityManagerFactory;

	public ProjectDAO() {
		entityManagerFactory = JpaUtil.getInstance().getEntityManagerFactory();
	}

	public int save(Project project) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (0 == project.getId()) {
				entityManager.persist(project);
			} else {
				entityManager.merge(project);
			}
			id = project.getId();
			entityManager.flush();
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		return id;
	}

	public Project get(int id) {
		Project project = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		project = entityManager.find(Project.class, id);
		entityManager.close();
		return project;
	}

	public void remove(int id) {
		Project project = get(id);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.remove(project);
			entityTransaction.commit();
		} catch (Exception exception) {
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
