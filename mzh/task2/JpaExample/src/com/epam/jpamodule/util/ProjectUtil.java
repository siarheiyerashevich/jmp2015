package com.epam.jpamodule.util;

import com.epam.jpamodule.model.Project;

public class ProjectUtil {

	public static final int COUNT_PROJECTS = 500;

	public static Project createProject(String name) {
		return new Project(name);
	}

}
