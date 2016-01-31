package com.smartsoft.corpowarehousedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.corpowarehousedemo.dao.EmployeeDAO;
import com.smartsoft.corpowarehousedemo.dao.PositionDAO;
import com.smartsoft.corpowarehousedemo.dao.PossessionDAO;
import com.smartsoft.corpowarehousedemo.model.Employee;
import com.smartsoft.corpowarehousedemo.model.Position;
import com.smartsoft.corpowarehousedemo.model.Possession;

@Service
public class EmployeesService {

	@Autowired private PositionDAO positionDAO;
	@Autowired private EmployeeDAO employeeDAO;
	@Autowired private PossessionDAO possessionDAO;

	public PositionDAO getPositionDAO() {
		return positionDAO;
	}
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	
	public PossessionDAO getPossessionDAO() {
		return possessionDAO;
	}
	
	public List<Position> getPositions(){
		return positionDAO.findAll(Position.class);
	}
	
	public List<Employee> getEmployees(){
		return employeeDAO.findAll(Employee.class);
	}
	
	public List<Possession> getPossessions(){
		return possessionDAO.findAll(Possession.class);
	}
	
    public void add(Employee entity) {
    	employeeDAO.add(entity);
    }
 
    public void update(Employee entity) {
    	employeeDAO.update(entity);
    }
	
}