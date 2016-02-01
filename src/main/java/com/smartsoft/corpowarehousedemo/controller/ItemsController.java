package com.smartsoft.corpowarehousedemo.controller;

import java.util.LinkedHashMap;
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
import com.smartsoft.corpowarehousedemo.model.ItemCategory;
import com.smartsoft.corpowarehousedemo.model.Possession;
import com.smartsoft.corpowarehousedemo.model.PossessionData;
import com.smartsoft.corpowarehousedemo.service.EmployeesService;
import com.smartsoft.corpowarehousedemo.service.ItemsService;

@Controller
public class ItemsController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
    @Autowired private ItemsService itemsService;
	
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("listItems", itemsService.getItems());
        return "item/list";
    }
    
    @RequestMapping(value= "/item/add", method = RequestMethod.GET)
    public String addItemView(Model model){
        model.addAttribute("item", new Item());
    	return "item/create";
    }
    
    @RequestMapping(value= "/item/add", method = RequestMethod.POST)
    public String addItemAction(@ModelAttribute("item") Item item){

    	ItemCategory category = itemsService.getItemCategories().get(0);
    	item.setCategory(category);
    	
    	if(item.getId() != 0){
    		logger.info("Updating item id {}", item.getId());
    		logger.info("Updating item name {}", item.getName());
    		logger.info("Updating item quantity {}", item.getQuantity());
    		logger.info("Updating item category {}", item.getCategory());
    		itemsService.updateItem(item);
    	} else {
    		logger.info("Adding item", item.getId());
        	if(item.getName() != ""){
        		itemsService.addItem(item);
        		logger.info("item id {}", item.getId());
        	}
    	}
        return "redirect:/items";
    }
    
    @RequestMapping(value= "/item/edit/{id}", method = RequestMethod.GET)
    public String editItem(@PathVariable("id") int id, Model model){
    	Item item = itemsService.getItem(id);
        model.addAttribute("item", item);
    	return "item/edit";
    }
    
    @RequestMapping("/item/remove/{id}")
    public String removeItem(@PathVariable("id") int id){
        itemsService.removeItem(id);
        return "redirect:/items";
    }
}
