package com.epam.jpamodule.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmployeeProjects
 *
 */
@Entity
@Table(name = "EmployeeProjects")
public class EmployeeProjects implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeProjectsId")
	private int id;

	public EmployeeProjects() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeProjects other = (EmployeeProjects) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeProjects [id=" + id + "]";
	}
}