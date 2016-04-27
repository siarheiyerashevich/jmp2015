package com.epam.jpamodule.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${com.epam.jpamodule.count.units}")
	private int countUnits;
	@Value("${com.epam.jpamodule.count.projects}")
	private int countProjects;
	@Value("${com.epam.jpamodule.count.employees}")
	private int countEmployees;
	@Value("${com.epam.jpamodule.default.count.projects}")
	private int defaultCountProjects;

	public int getCountUnits() {
		return countUnits;
	}

	public void setCountUnits(int countUnits) {
		this.countUnits = countUnits;
	}

	public int getCountProjects() {
		return countProjects;
	}

	public void setCountProjects(int countProjects) {
		this.countProjects = countProjects;
	}

	public int getCountEmployees() {
		return countEmployees;
	}

	public void setCountEmployees(int countEmployees) {
		this.countEmployees = countEmployees;
	}

	public int getDefaultCountProjects() {
		return defaultCountProjects;
	}

	public void setDefaultCountProjects(int defaultCountProjects) {
		this.defaultCountProjects = defaultCountProjects;
	}
}
