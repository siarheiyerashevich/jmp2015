package com.epam.jpamodule.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.epam.jpamodule.dao.EmployeeDAO;
import com.epam.jpamodule.model.Address;
import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.EmployeeStatus;
import com.epam.jpamodule.model.PersonalInfo;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.model.Unit;
import static com.epam.jpamodule.util.EmployeeUtil.*;
import static com.epam.jpamodule.util.ProjectUtil.*;
import static com.epam.jpamodule.util.UnitUtil.*;

public class EmployeeService {

	public static final int DEFAULT_COUNT_PROJECTS = 5;

	private EmployeeDAO employeeDAO;
	private AddressService addressService;
	private PersonalInfoService personalInfoService;
	private ProjectService projectService;
	private UnitService unitService;

	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
		addressService = new AddressService();
		personalInfoService = new PersonalInfoService();
		projectService = new ProjectService();
		unitService = new UnitService();
	}

	public void insertEmployees() {
		for (int i = 0; i < COUNT_EMPLOYEES; i++) {
			Employee employee;
			Random random = new Random();
			Address address = addressService.get(i);
			PersonalInfo personalInfo = personalInfoService.get(i);
			Unit unit = unitService.get(i % COUNT_UNITS);
			Set<Project> projects = new HashSet<>();
			int countProjects = random.nextInt(DEFAULT_COUNT_PROJECTS);
			for (int j = 0; j < countProjects; j++) {
				int num = random.nextInt(COUNT_PROJECTS);
				projects.add(projectService.get(num));
			}
			if (i % 2 == 0) {
				employee = createEmployee("LastName" + i, "FirstName" + i, EmployeeStatus.FULL_TIME_EMPLOYEE, address,
						unit, personalInfo, projects);
			} else {
				employee = createEmployee("LastName" + i, "FirstName" + i, EmployeeStatus.PART_TIME_EMPLOYEE, address,
						unit, personalInfo, projects);
			}
			employeeDAO.save(employee);
		}
	}

	public int save(Employee employee) {
		return employeeDAO.save(employee);
	}

	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	public void remove(int id) {
		employeeDAO.remove(id);
	}
}
