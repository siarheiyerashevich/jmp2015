package com.epam.jpamodule.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpamodule.dao.UnitDAO;
import com.epam.jpamodule.model.Unit;
import com.epam.jpamodule.resource.AppConfig;

@Service
@Transactional
public class UnitService {

	@Autowired
	private UnitDAO unitDAO;
	@Autowired
	private AppConfig appConfig;

	public UnitService() {
		unitDAO = new UnitDAO();
	}

	@Transactional
	public void insertUnits() {
		List<Unit> units = new ArrayList<>();
		for (int i = 1; i <= appConfig.getCountUnits(); i++) {
			Unit unit = new Unit("UnitName " + i);
			units.add(unit);
		}
		unitDAO.insertUnits(units);
	}

	@Transactional
	public int save(Unit unit) {
		return unitDAO.save(unit);
	}

	public Unit get(int id) {
		return unitDAO.get(id);
	}

	@Transactional
	public void remove(int id) throws Exception {
		unitDAO.remove(id);
	}

	public UnitDAO getUnitDAO() {
		return unitDAO;
	}

	public void setUnitDAO(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
}
