package com.smartsoft.corpowarehousedemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartsoft.corpowarehousedemo.service.EmployeesService;

@Controller
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
    @Autowired
    private EmployeesService employeesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		
		logger.info("list positions {}", employeesService.getPositions());
		logger.info("list employees {}", employeesService.getEmployees());
		
		return "employee";
	}
	
}