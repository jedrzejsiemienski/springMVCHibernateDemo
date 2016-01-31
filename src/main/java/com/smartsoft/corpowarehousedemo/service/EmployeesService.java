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
	
	public List<Position> getPositions(){
		return positionDAO.findAll(Position.class);
	}
	
	public Position getPosition(long id){
		return positionDAO.getById(Position.class, id);
	}
	
    public void addPosition(Position entity) {
    	positionDAO.add(entity);
    }
 
    public void updatePosition(Position entity) {
    	positionDAO.update(entity);
    }
    
    public void removePosition(long id) {
    	positionDAO.remove(Position.class, id);
    }
    
	
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public List<Employee> getEmployees(){
		return employeeDAO.findAll(Employee.class);
	}
	
	public Employee getEmployee(long id){
		return employeeDAO.getById(Employee.class, id);
	}
	
    public void addEmployee(Employee entity) {
    	employeeDAO.add(entity);
    }
 
    public void updateEmployee(Employee entity) {
    	employeeDAO.update(entity);
    }
    
    public void removeEmployee(long id) {
    	employeeDAO.remove(Employee.class, id);
    }
    

	
	public PossessionDAO getPossessionDAO() {
		return possessionDAO;
	}
	
	public List<Possession> getPossessions(){
		return possessionDAO.findAll(Possession.class);
	}
	
	public Possession getPossession(long id){
		return possessionDAO.getById(Possession.class, id);
	}
	
    public void addPossession(Possession entity) {
    	possessionDAO.add(entity);
    }
 
    public void updatePossession(Possession entity) {
    	possessionDAO.update(entity);
    }
    
    public void removePossession(long id) {
    	possessionDAO.remove(Possession.class, id);
    }
	
}