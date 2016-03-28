package com.epam.jpamodule.util;

import com.epam.jpamodule.model.Address;

public class AddressUtil {

	public static final int COUNT_ADDRESSES = 100;

	public static Address createAddress(String countryName, String cityName) {
		return new Address(countryName, cityName);
	}

}
