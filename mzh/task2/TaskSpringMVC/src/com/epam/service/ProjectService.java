package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.dao.ProjectDAO;
import com.epam.model.Project;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	public ProjectService() {
		super();
	}

	public Project get(int id) {
		return projectDAO.get(id);
	}

	public Project getProjectByName(String name) {
		return projectDAO.getProjectByName(name);
	}

	public List<Project> getProjects() {
		return projectDAO.getProjects();
	}

	public void save(Project project) throws Exception {
		projectDAO.save(project);
	}

	public void remove(int id) throws Exception {
		projectDAO.remove(id);
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
}