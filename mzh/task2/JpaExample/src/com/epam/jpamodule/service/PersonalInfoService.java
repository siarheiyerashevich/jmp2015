package com.epam.jpamodule.service;

import com.epam.jpamodule.dao.PersonalInfoDAO;
import com.epam.jpamodule.model.PersonalInfo;
import static com.epam.jpamodule.util.PersonalInfoUtil.*;

public class PersonalInfoService {

	private PersonalInfoDAO personalInfoDAO;

	public PersonalInfoService() {
		personalInfoDAO = new PersonalInfoDAO();
	}

	public void insertPersonalInfoes() {
		for (int i = 0; i < COUNT_PERSONAl_INFO; i++) {
			PersonalInfo personalInfo = createPersonalInfo("PassportNumber " + i, "DriverLisenceNumber " + i);
			personalInfoDAO.add(personalInfo);
		}
	}

	public PersonalInfo get(int id) {
		return personalInfoDAO.get(id);
	}
}
