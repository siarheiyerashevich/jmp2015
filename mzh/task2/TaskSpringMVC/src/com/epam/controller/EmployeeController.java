package com.epam.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.model.Employee;
import com.epam.model.EmployeeStatus;
import com.epam.model.Project;
import com.epam.model.Unit;
import com.epam.service.EmployeeService;
import com.epam.service.ProjectService;
import com.epam.service.UnitService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(Model model) {
		try {
			List<Employee> employees = employeeService.getEmployees();
			model.addAttribute("employees", employees);
		} catch (Exception exception) {
			return "error";
		}
		return "employees";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String addPage(Model model) {
		try {
			addModelAttribute(model);
			model.addAttribute("employee", new Employee());
		} catch (Exception exception) {
			return "error";
		}
		return "employee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String add(@ModelAttribute("employee") Employee employee) {
		try {
			employee.setUnit(updateUnit(employee));
			employee.setProjects(updateProjects(employee));
			employeeService.save(employee);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, Model model) {
		try {
			addModelAttribute(model);
			model.addAttribute("employee", employeeService.get(id));
		} catch (Exception exception) {
			return "error";
		}
		return "employee";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee) {
		try {
			employee.setUnit(updateUnit(employee));
			employee.setProjects(updateProjects(employee));
			employeeService.save(employee);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employee/{id}/remove")
	public String remove(@PathVariable Integer id) {
		try {
			employeeService.remove(id);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/employees";
	}

	private void addModelAttribute(Model model) {
		model.addAttribute("statuses",
				Arrays.asList(EmployeeStatus.FULL_TIME_EMPLOYEE, EmployeeStatus.PART_TIME_EMPLOYEE));
		model.addAttribute("units", unitService.getUnits());
		model.addAttribute("projects", projectService.getProjects());
	}

	private Unit updateUnit(Employee employee) {
		return unitService.getUnitByName(employee.getUnit().getName());
	}

	private Set<Project> updateProjects(Employee employee) {
		Set<Project> projects = new HashSet<>();
		for (Project project : employee.getProjects()) {
			projects.add(projectService.getProjectByName(project.getName()));
		}
		return projects;
	}
}
