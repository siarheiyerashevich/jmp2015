package com.epam.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.epam.model.Address;
import com.epam.model.Employee;
import com.epam.model.EmployeeStatus;
import com.epam.model.PersonalInfo;
import com.epam.model.Project;
import com.epam.model.Unit;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 8252260271431913111L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private Integer id;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "FirstName")
	private String firstName;

	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressId")
	private Address address;

	@ManyToOne(optional = true)
	@JoinColumn(name = "UnitId", nullable = true)
	private Unit unit;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PersonalInfoId")
	private PersonalInfo personalInfo;

	@ManyToMany
	@JoinTable(name = "EmployeeProjects", joinColumns = @JoinColumn(name = "EmployeeId") , inverseJoinColumns = @JoinColumn(name = "ProjectId") )
	private Set<Project> projects;

	public Employee() {
		super();
	}

	public Employee(String lastName, String firstName, EmployeeStatus status, Address address, Unit unit,
			PersonalInfo personalInfo, Set<Project> projects) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.status = status;
		this.unit = unit;
		this.address = address;
		this.personalInfo = personalInfo;
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		if (status != other.status)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", status=" + status
				+ ", address=" + address + ", unit=" + unit + ", personalInfo=" + personalInfo + ", projects="
				+ projects + "]";
	}
}