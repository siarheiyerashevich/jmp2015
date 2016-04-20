package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.service.UnitService;

@Controller
public class UnitController {

	@Autowired
	private UnitService unitService;

	@RequestMapping(value = "/units", method = RequestMethod.GET)
	public String units(Model model) {
		try {
			model.addAttribute("units", unitService.getUnits());
		} catch (Exception exception) {
			return "error";
		}
		return "units";
	}

	@RequestMapping(value = "/unit/{id}/remove")
	public String remove(@PathVariable("id") Integer id) {
		try {
			unitService.remove(id);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/units";
	}

}
