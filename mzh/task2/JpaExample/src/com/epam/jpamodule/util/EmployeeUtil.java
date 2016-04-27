package com.epam.jpamodule.util;

import java.util.Set;

import com.epam.jpamodule.model.Address;
import com.epam.jpamodule.model.Employee;
import com.epam.jpamodule.model.EmployeeStatus;
import com.epam.jpamodule.model.PersonalInfo;
import com.epam.jpamodule.model.Project;
import com.epam.jpamodule.model.Unit;

public class EmployeeUtil {

	public static final int COUNT_EMPLOYEES = 100;
	
	public static Employee createEmployee(String lastName, String firstName, EmployeeStatus status, Address address,
			Unit unit, PersonalInfo personalInfo, Set<Project> projects) {
		return new Employee(lastName, firstName, status, address, unit, personalInfo, projects);
	}

}
