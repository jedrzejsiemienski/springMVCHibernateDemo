package com.smartsoft.corpowarehousedemo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.smartsoft.corpowarehousedemo.model.Possession;
import com.smartsoft.corpowarehousedemo.model.PossessionData;
import com.smartsoft.corpowarehousedemo.service.EmployeesService;
import com.smartsoft.corpowarehousedemo.service.ItemsService;
import com.smartsoft.corpowarehousedemo.utils.Utils;

@Controller
public class EmployeesController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
    @Autowired private EmployeesService employeesService;
    @Autowired private ItemsService itemsService;
	
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("listEmployees", employeesService.getEmployees());
        return "employee/list";
    }
     
    @RequestMapping(value= "/employee/add", method = RequestMethod.GET)
    public String addEmployeView(Model model){
        model.addAttribute("employee", new Employee());
    	return "employee/create";
    }
    
    @RequestMapping(value= "/employee/add", method = RequestMethod.POST)
    public String addEmployeeAction(@ModelAttribute("employee") Employee p){
    	employeesService.addEmployee(p);
        return "redirect:/employee/edit/" + p.getId();
    }
    
    @RequestMapping("/employee/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        employeesService.removeEmployee(id);
        return "redirect:/employees";
    }
  
    @RequestMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
    	Employee e = employeesService.getEmployee(id);
    	model.addAttribute("employee", e);
    	
    	Map<Long, String> items = new LinkedHashMap<Long, String>();
    	for(Item item : itemsService.getItems()){
    		if(item.getQuantity() > 0){
    			items.put(item.getId(), item.getName() + " (pozostalo sztuk " + item.getQuantity() + ")");
    		}
    	}
    	model.addAttribute("items", items);
        
        List<Possession> possessionsSorted = Utils.asSortedList(e.getPossessions());
        model.addAttribute("possessions", possessionsSorted);
        
        PossessionData pd = new PossessionData();
        pd.setEmployeeId((long)id);
        model.addAttribute("possessionData", pd);
        
        return "employee/edit";
    }
    
    @RequestMapping(value= "/employee/edit/addPossesion", method = RequestMethod.POST)
	public String addPossesionToEmployee(@ModelAttribute("possessionData") PossessionData pd){
    	
    	Item item = itemsService.getItem(pd.getItemId());
    	Employee employee = employeesService.getEmployee(pd.getEmployeeId());
    	
    	if(item != null && item.getQuantity() > 0 && employee != null){
    		Possession p = new Possession();
        	p.setItem(item);
        	p.setEmployee(employee);
        	employeesService.addPossession(p);
        	
        	item.setQuantity(item.getQuantity() - 1);
        	itemsService.updateItem(item);
    	}
    	
    	return "redirect:/employee/edit/" + pd.getEmployeeId();
    }
    
    @RequestMapping("/employee/removePossession/{pid}/{eid}")
    public String removePossession(@PathVariable("pid") long pid, @PathVariable("eid") long eid){
    	Possession p = employeesService.getPossession(pid);
    	Item item = p.getItem();
    	item.setQuantity(item.getQuantity() + 1);
    	itemsService.updateItem(item);
    	
        employeesService.removePossession(pid);
        return "redirect:/employee/edit/" + eid;
    }
}