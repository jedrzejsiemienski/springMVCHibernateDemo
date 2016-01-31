package com.smartsoft.corpowarehousedemo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartsoft.corpowarehousedemo.model.Employee;
import com.smartsoft.corpowarehousedemo.model.Item;
import com.smartsoft.corpowarehousedemo.model.Position;
import com.smartsoft.corpowarehousedemo.model.Possession;
import com.smartsoft.corpowarehousedemo.model.PossessionData;
import com.smartsoft.corpowarehousedemo.service.EmployeesService;
import com.smartsoft.corpowarehousedemo.service.ItemsService;

@Controller
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
    @Autowired private EmployeesService employeesService;
    @Autowired private ItemsService itemsService;
	
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", employeesService.getEmployees());
        return "employee/list";
    }
     
    //For add and update employee both
    @RequestMapping(value= "/employee/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee p){
         
        if(p.getId() == 0){
            //new employee, add it
            employeesService.addEmployee(p);
        }else{
            //existing employee, call update
            employeesService.updateEmployee(p);
        }
         
        //return "redirect:/employees";
        return "redirect:/edit/" + p.getId();
    }
     
    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        employeesService.removeEmployee(id);
        return "redirect:/employees";
    }
  
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
    	Employee e = employeesService.getEmployee(id);
    	   	
    	Map<Long, String> items = new LinkedHashMap<Long, String>();
    	for(Item item : itemsService.getItems()){
    		items.put(item.getId(), item.getName());
    	}
    	
        model.addAttribute("employee", e);
        model.addAttribute("possessions", e.getPossessions());
        model.addAttribute("items", items);
        PossessionData pd = new PossessionData();
        pd.setEmployeeId((long)id);
        model.addAttribute("possessionData", pd);
        return "employee/employee";
    }
    
    @RequestMapping(value= "/edit/addPossesion", method = RequestMethod.POST)
	public String addPossesionToEmployee(@ModelAttribute("possessionData") PossessionData pd){
    	
    	logger.info("item id = {}", pd.getItemId());
    	logger.info("employe id = {}", pd.getEmployeeId());
    	
    	Item item = itemsService.getItem(pd.getItemId());
    	Employee employee = employeesService.getEmployee(pd.getEmployeeId());
    	
    	logger.info("item {}", item);
    	logger.info("employee {}", employee);
    	
    	if(item != null && employee != null){
    		Possession p = new Possession();
        	p.setItem(item);
        	p.setEmployee(employee);
        	
        	logger.info("Possession {}", p);
        	
        	employeesService.addPossession(p);
        	
        	logger.info("Added!");
    	}
    	
    	return "redirect:/edit/" + pd.getEmployeeId();
    }
}