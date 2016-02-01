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
    	logger.info("items list = {}", itemsService.getItems());
        model.addAttribute("listItems", itemsService.getItems());
        return "items/list";
    }
}
