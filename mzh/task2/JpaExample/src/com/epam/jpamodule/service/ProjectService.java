package com.epam.jpamodule.service;

import com.epam.jpamodule.dao.ProjectDAO;
import com.epam.jpamodule.model.Project;
import static com.epam.jpamodule.util.ProjectUtil.*;

public class ProjectService {

	private ProjectDAO projectDAO;

	public ProjectService() {
		projectDAO = new ProjectDAO();
	}

	public void insertProjects() {
		for (int i = 0; i < COUNT_PROJECTS; i++) {
			Project project = createProject("Name " + i);
			projectDAO.save(project);
		}
	}

	public int save(Project project) {
		return projectDAO.save(project);
	}

	public Project get(int id) {
		return projectDAO.get(id);
	}

	public void remove(int id) {
		projectDAO.remove(id);
	}

}
