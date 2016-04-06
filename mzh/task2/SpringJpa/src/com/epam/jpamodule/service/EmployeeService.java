package com.epam.jpamodule.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.jpamodule.dao.EmployeeDAO;
import com.epam.jpamodule.model.Address;
import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.EmployeeStatus;
import com.epam.jpamodule.model.PersonalInfo;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.model.Unit;
import com.epam.jpamodule.resource.AppConfig;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private AppConfig appConfig;

	public EmployeeService() {
		super();
	}

	public void insertEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i <= appConfig.getCountEmployees(); i++) {
			Random random = new Random();
			Address address = new Address("Country " + i, "City " + i);
			PersonalInfo personalInfo = new PersonalInfo("PassportNumber " + i, "DriverLisenceNumber " + i);
			Unit unit = unitService.get(i % appConfig.getCountUnits() + 1);
			Set<Project> projects = new HashSet<>();
			int countProjects = random.nextInt(appConfig.getDefaultCountProjects());
			for (int j = 0; j < countProjects; j++) {
				int num = random.nextInt(appConfig.getCountProjects());
				projects.add(projectService.get(num));
			}
			EmployeeStatus status = i % 2 == 0 ? EmployeeStatus.FULL_TIME_EMPLOYEE : EmployeeStatus.PART_TIME_EMPLOYEE;
			Employee employee = new Employee("LastName " + i, "FirstName " + i, status, address, unit, personalInfo,
					projects);
			employees.add(employee);
		}
		employeeDAO.insertEmployees(employees);
	}

	public void save() {
		Employee employee1 = new Employee("New LastName", "New FirstName", EmployeeStatus.FULL_TIME_EMPLOYEE,
				new Address("Country", "City"), null, new PersonalInfo("124", "234"), Collections.EMPTY_SET);
		Employee employee2 = new Employee("New LastName", "New FirstName", EmployeeStatus.FULL_TIME_EMPLOYEE,
				new Address("Country", "City"), null, new PersonalInfo("124", "234"), Collections.EMPTY_SET);
		employeeDAO.save(employee1);
		employeeDAO.save(employee2);
	}

	public int save(Employee employee) {
		return employeeDAO.save(employee);
	}

	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	public Employee getByLastName(String lastName) {
		return employeeDAO.getByLastName(lastName);
	}

	public Employee getByCountry(String country) {
		return employeeDAO.getByCountry(country);
	}

	public void remove(int id) throws Exception {
		employeeDAO.remove(id);
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
}
