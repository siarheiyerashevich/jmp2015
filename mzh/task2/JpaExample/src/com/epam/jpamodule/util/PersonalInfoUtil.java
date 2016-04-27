package com.epam.jpamodule.util;

import com.epam.jpamodule.model.PersonalInfo;

public class PersonalInfoUtil {

	public static final int COUNT_PERSONAl_INFO = 100;

	public static PersonalInfo createPersonalInfo(String passportNumber, String driverLicenseNumber) {
		return new PersonalInfo(passportNumber, driverLicenseNumber);
	}
}
