package com.epam.jpamodule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpamodule.model.Project;

@Component
public class ProjectDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectDAO() {
		super();
	}

	@Transactional
	public void insertProjects(List<Project> projects) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			for (Project project : projects) {
				entityManager.persist(project);
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
	public int save(Project project) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (null == project.getId()) {
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

	@Transactional
	public void remove(int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Project project = entityManager.find(Project.class, id);
			entityManager.remove(project);
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
