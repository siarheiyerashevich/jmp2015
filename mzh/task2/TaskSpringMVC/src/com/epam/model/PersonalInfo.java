package com.epam.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalInfo")
public class PersonalInfo implements Serializable {

	private static final long serialVersionUID = -4471896024896434399L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PersonalInfoId")
	private Integer id;

	@Column(name = "PassportNumber")
	private String passportNumber;

	@Column(name = "DriverLisenceNumber")
	private String driverLicenseNumber;

	public PersonalInfo() {
		super();
	}

	public PersonalInfo(String passportNumber, String driverLicenseNumber) {
		super();
		this.passportNumber = passportNumber;
		this.driverLicenseNumber = driverLicenseNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getDriverLicenseNumber() {
		return driverLicenseNumber;
	}

	public void setDriverLicenseNumber(String driverLicenseNumber) {
		this.driverLicenseNumber = driverLicenseNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverLicenseNumber == null) ? 0 : driverLicenseNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passportNumber == null) ? 0 : passportNumber.hashCode());
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
		PersonalInfo other = (PersonalInfo) obj;
		if (driverLicenseNumber == null) {
			if (other.driverLicenseNumber != null)
				return false;
		} else if (!driverLicenseNumber.equals(other.driverLicenseNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonalInfo [id=" + id + ", passportNumber=" + passportNumber + ", driverLicenseNumber="
				+ driverLicenseNumber + "]";
	}
}