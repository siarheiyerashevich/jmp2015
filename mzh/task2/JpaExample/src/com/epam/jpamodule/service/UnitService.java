package com.epam.jpamodule.service;

import com.epam.jpamodule.dao.UnitDAO;
import com.epam.jpamodule.model.Unit;
import static com.epam.jpamodule.util.UnitUtil.*;

public class UnitService {

	private UnitDAO unitDAO;

	public UnitService() {
		unitDAO = new UnitDAO();
	}

	public void insertUnits() {
		for (int i = 0; i < COUNT_UNITS; i++) {
			Unit unit = createUnit("Name " + i);
			unitDAO.save(unit);
		}
	}

	public int save(Unit unit) {
		return unitDAO.save(unit);
	}

	public Unit get(int id) {
		return unitDAO.get(id);
	}

	public void remove(int id) {
		unitDAO.remove(id);
	}
}
