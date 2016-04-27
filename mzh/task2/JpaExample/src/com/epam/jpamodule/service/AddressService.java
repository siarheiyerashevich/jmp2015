package com.epam.jpamodule.service;

import com.epam.jpamodule.dao.AddressDAO;
import com.epam.jpamodule.model.Address;
import static com.epam.jpamodule.util.AddressUtil.*;

public class AddressService {

	private AddressDAO addressDAO;

	public AddressService() {
		addressDAO = new AddressDAO();
	}

	public void insertAddresses() {
		for (int i = 0; i < COUNT_ADDRESSES; i++) {
			addressDAO.add(createAddress("Country " + i, "City " + i));
		}
	}

	public Address get(int id) {
		return addressDAO.get(id);
	}
}
