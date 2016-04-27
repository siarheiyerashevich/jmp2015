package com.epam.jpamodule.util;

import com.epam.jpamodule.model.Unit;

public class UnitUtil {

	public static final int COUNT_UNITS = 30;

	public static Unit createUnit(String name) {
		return new Unit(name);
	}

}
