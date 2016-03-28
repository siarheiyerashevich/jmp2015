package com.epam.jpamodule.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PersonalInfo
 *
 */
@Entity
@Table(name = "PersonalInfo")
public class PersonalInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PersonalInfoId")
	private int id;

	@Column(name = "PassportNumber")
	private String passportNumber;

	@Column(name = "DriverLicenseNumber")
	private String driverLicenseNumber;

	public PersonalInfo() {
		super();
	}

	public PersonalInfo(String passportNumber, String driverLicenseNumber) {
		super();
		this.passportNumber = passportNumber;
		this.driverLicenseNumber = driverLicenseNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		result = prime * result + id;
		result = prime * result + ((driverLicenseNumber == null) ? 0 : driverLicenseNumber.hashCode());
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
		if (id != other.id) {
			return false;
		}
		if (driverLicenseNumber == null) {
			if (other.driverLicenseNumber != null)
				return false;
		} else if (!driverLicenseNumber.equals(other.driverLicenseNumber))
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
