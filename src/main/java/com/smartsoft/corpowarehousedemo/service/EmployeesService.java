package com.smartsoft.corpowarehousedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.corpowarehousedemo.dao.EmployeeDAO;
import com.smartsoft.corpowarehousedemo.dao.PositionDAO;
import com.smartsoft.corpowarehousedemo.model.Employee;
import com.smartsoft.corpowarehousedemo.model.Position;

@Service
public class EmployeesService {

	@Autowired private PositionDAO positionDAO;
	@Autowired private EmployeeDAO employeeDAO;

	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	
	public List<Position> getPositions(){
		return positionDAO.findAll();
	}
	
	public List<Employee> getEmployees(){
		return employeeDAO.findAll();
	}
	
}