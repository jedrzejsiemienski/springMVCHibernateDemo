package com.smartsoft.corpowarehousedemo.controller;

import java.util.List;

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
import com.smartsoft.corpowarehousedemo.model.Position;
import com.smartsoft.corpowarehousedemo.model.Possession;
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
        return "employee";
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
         
        return "redirect:/employees";
    }
     
    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        employeesService.removeEmployee(id);
        return "redirect:/employees";
    }
  
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeesService.getEmployee(id));
        model.addAttribute("listEmployees", employeesService.getEmployees());
        return "employee";
    }    
	
}