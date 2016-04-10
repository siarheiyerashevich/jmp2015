package com.epam.jpamodule.controller;

import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.model.Unit;
import com.epam.jpamodule.service.EmployeeService;
import com.epam.jpamodule.service.ProjectService;
import com.epam.jpamodule.service.UnitService;

public class Controller {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
			ProjectService projectService = (ProjectService) context.getBean("projectService");
			UnitService unitService = (UnitService) context.getBean("unitService");
			EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

			// insert data
			// long startTime = System.currentTimeMillis();
			// projectService.insertProjects();
			// unitService.insertUnits();
			// employeeService.insertEmployees();
			// long executionTime = System.currentTimeMillis() - startTime;
			// System.out.println("Execution time: " + executionTime);

			// find
			// System.out.println("Find employee by id: "
			// + employeeService.get(new
			// Random().nextInt(employeeService.getAppConfig().getCountEmployees())));
			// System.out.println("Find project by id: "
			// + projectService.get(new
			// Random().nextInt(employeeService.getAppConfig().getCountProjects())));
			// System.out.println("Find unit by id: "
			// + unitService.get(new
			// Random().nextInt(employeeService.getAppConfig().getCountUnits())));
			// System.out.println("Find employee by Last Name: " +
			// employeeService.getByLastName("LastName 1"));
			// System.out.println("Find employee by Country: " + employeeService.getByCountry("Country 1"));

			// update
//			int employeeId = new Random().nextInt(employeeService.getAppConfig().getCountEmployees());
//			Employee employee = employeeService.get(employeeId);
//			employee.setLastName("New LastName " + employeeId);
//			employee.setFirstName("New FirstName " + employeeId);
//			employeeId = employeeService.save(employee);
//			System.out.println("Update employee: " + employeeService.get(employeeId));
//
//			int unitId = new Random().nextInt(employeeService.getAppConfig().getCountUnits());
//			Unit unit = unitService.get(unitId);
//			unit.setName("New UnitName " + unitId);
//			unitId = unitService.save(unit);
//			System.out.println("Update unit: " + unitService.get(unitId));
//
//			int projectId = new Random().nextInt(employeeService.getAppConfig().getCountProjects());
//			Project project = projectService.get(projectId);
//			project.setName("New ProjectName " + projectId);
//			projectId = projectService.save(project);
//			System.out.println("Update project: " + projectService.get(projectId));

			// update employee's unit
//			employeeId = new Random().nextInt(employeeService.getAppConfig().getCountEmployees());
//			employee = employeeService.get(employeeId);
//			unit = new Unit("New New UnitName " + employeeId);
//			unitService.save(unit);
//			employee.setUnit(unit);
//			employeeId = employeeService.save(employee);
//			System.out.println("Update employee's unit: " + employeeService.get(employeeId));

			// remove
//			unitId = new Random().nextInt(employeeService.getAppConfig().getCountUnits());
//			try {
//				unitService.remove(unitId);
//				System.out.println("Remove unit with id = " + unitId);
//			} catch (Exception exception) {
//				System.out.println("Something goes wrong...Ooops");
//			}
//
//			employeeId = new Random().nextInt(employeeService.getAppConfig().getCountEmployees());
//			try {
//				employeeService.remove(employeeId);
//				System.out.println("Remove employee with id = " + employeeId);
//			} catch (Exception exception) {
//				System.out.println("Something goes wrong...Ooops");
//			}
//
//			projectId = new Random().nextInt(employeeService.getAppConfig().getCountProjects());
//			try {
//				projectService.remove(projectId);
//				System.out.println("Remove project with id = " + projectId);
//			} catch (Exception exception) {
//				System.out.println("Something goes wrong...Ooops");
//			}

			employeeService.testSave();
		}
	}
}
