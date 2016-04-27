package com.epam.jpamodule.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.epam.jpamodule.model.Project;

@Repository
public class ProjectDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectDAO() {
		super();
	}

	public void insertProjects(List<Project> projects) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			for (Project project : projects) {
				entityManager.persist(project);
			}
			entityManager.flush();
		} finally {
			entityManager.close();
		}
	}

	public int save(Project project) {
		int id = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (null == project.getId()) {
				entityManager.persist(project);
			} else {
				entityManager.merge(project);
			}
			id = project.getId();
			entityManager.flush();
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

	public void remove(int id) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Project project = entityManager.find(Project.class, id);
			entityManager.remove(project);
		} catch (Exception exception) {
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
