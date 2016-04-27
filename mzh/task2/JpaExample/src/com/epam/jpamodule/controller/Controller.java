package com.epam.jpamodule.controller;

import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.model.Unit;
import com.epam.jpamodule.service.AddressService;
import com.epam.jpamodule.service.EmployeeService;
import com.epam.jpamodule.service.PersonalInfoService;
import com.epam.jpamodule.service.ProjectService;
import com.epam.jpamodule.service.UnitService;
import static com.epam.jpamodule.util.ProjectUtil.*;
import static com.epam.jpamodule.util.UnitUtil.*;
import static com.epam.jpamodule.util.EmployeeUtil.*;

import java.util.Random;

public class Controller {

	public static void main(String[] args) {

		/* init */
		AddressService addressService = new AddressService();
		addressService.insertAddresses();

		PersonalInfoService personalInfoService = new PersonalInfoService();
		personalInfoService.insertPersonalInfoes();

		ProjectService projectService = new ProjectService();
		projectService.insertProjects();

		UnitService unitService = new UnitService();
		unitService.insertUnits();

		EmployeeService employeeService = new EmployeeService();
		employeeService.insertEmployees();

		/* find */
		System.out.println("Find employee by id:\n" + employeeService.get(new Random().nextInt(COUNT_EMPLOYEES)));
		System.out.println("Find unit by id:\n" + unitService.get(new Random().nextInt(COUNT_UNITS)));
		System.out.println("Find project by id:\n" + projectService.get(new Random().nextInt(COUNT_PROJECTS)));

		/* update */
		Employee employee = employeeService.get(new Random().nextInt(COUNT_EMPLOYEES));
		employee.setLastName("New LastName");
		employee.setFirstName("New FirstName");
		int employeeId = employeeService.save(employee);
		System.out.println("Update employee:\n" + employeeService.get(employeeId));

		Unit unit = unitService.get(new Random().nextInt(COUNT_UNITS));
		unit.setName("New UnitName");
		int unitId = unitService.save(unit);
		System.out.println("Update unit:\n" + unitService.get(unitId));

		Project project = projectService.get(new Random().nextInt(COUNT_PROJECTS));
		project.setName("New ProjectName");
		int projectId = projectService.save(project);
		System.out.println("Update project:\n" + projectService.get(projectId));

		/* update employee's unit */
		employee = employeeService.get(new Random().nextInt(COUNT_EMPLOYEES));
		unit = new Unit("New UnitName2");
		unitId = unitService.save(unit);
		employee.setUnit(unit);
		employeeId = employeeService.save(employee);
		System.out.println("Update employee's unit:\n" + employeeService.get(employeeId));

		/* update employee's projects */
		employee = employeeService.get(new Random().nextInt(COUNT_EMPLOYEES));
		project = new Project("New ProjectName2");
		projectId = projectService.save(project);
		employee.getProjects().add(project);
		employeeId = employeeService.save(employee);
		System.out.println("Update employee's projects:\n" + employeeService.get(employeeId));

		/* remove */
		employeeService.remove(employeeId);
		unitService.remove(unitId);
		projectService.remove(projectId);
	}
}
