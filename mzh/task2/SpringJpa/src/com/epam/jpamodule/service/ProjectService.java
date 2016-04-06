package com.epam.jpamodule.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.jpamodule.dao.ProjectDAO;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.resource.AppConfig;

@Service
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private AppConfig appConfig;

	public ProjectService() {
		super();
	}

	//transaction
	public void insertProjects() {
		List<Project> projects = new ArrayList<>();
		for (int i = 1; i <= appConfig.getCountProjects(); i++) {
			Project project = new Project("ProjectName " + i);
			projects.add(project);
		}
		projectDAO.insertProjects(projects);
	}

	public int save(Project project) {
		return projectDAO.save(project);
	}

	public Project get(int id) {
		return projectDAO.get(id);
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

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
}
