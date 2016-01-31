package com.smartsoft.corpowarehousedemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartsoft.corpowarehousedemo.dao.EmployeeDAO;
import com.smartsoft.corpowarehousedemo.dao.PositionDAO;
import com.smartsoft.corpowarehousedemo.model.Employee;
import com.smartsoft.corpowarehousedemo.model.Position;

@Controller
public class EmployeesController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
	@Autowired private PositionDAO positionDAO;
	@Autowired private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		logger.info("listEmployees");
		
		List<Position> positions = positionDAO.findAll();
		logger.info("list positions {}", positions);
		
		List<Employee> employees = employeeDAO.findAll();
		logger.info("listEmployees {}", employees);
		
		return "employee";
	}
	
}