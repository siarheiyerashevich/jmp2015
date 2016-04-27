package com.epam.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.dao.UnitDAO;
import com.epam.model.Unit;

@Service
@Transactional
public class UnitService {

	@Autowired
	private UnitDAO unitDAO;

	public UnitService() {
		unitDAO = new UnitDAO();
	}

	public Unit get(int id) {
		return unitDAO.get(id);
	}

	public Unit getUnitByName(String name) {
		return unitDAO.getUnitByName(name);
	}

	public List<Unit> getUnits() {
		return unitDAO.getUnits();
	}

	public void save(Unit unit) throws Exception {
		unitDAO.save(unit);
	}

	public void remove(int id) throws Exception {
		unitDAO.remove(id);
	}

	public UnitDAO getUnitDAO() {
		return unitDAO;
	}

	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}
}