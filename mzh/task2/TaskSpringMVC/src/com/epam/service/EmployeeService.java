package com.epam.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.epam.dao.EmployeeDAO;
import com.epam.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UnitService unitService;

	public EmployeeService() {
		super();
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

	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	public void save(Employee employee) throws Exception {
		employeeDAO.save(employee);
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
}