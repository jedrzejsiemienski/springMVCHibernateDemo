package com.smartsoft.corpowarehousedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.corpowarehousedemo.dao.ItemCategoryDAO;
import com.smartsoft.corpowarehousedemo.dao.ItemDAO;
import com.smartsoft.corpowarehousedemo.model.Item;
import com.smartsoft.corpowarehousedemo.model.ItemCategory;

@Service
public class ItemsService {

	@Autowired private ItemDAO itemDAO;
	@Autowired private ItemCategoryDAO itemCategoryDAO;

	public ItemDAO getItemDAO() {
		return itemDAO;
	}
	
	public ItemCategoryDAO getItemCategoryDAO() {
		return itemCategoryDAO;
	}
	
	public List<Item> getItems(){
		return itemDAO.findAll(Item.class);
	}
	
	public List<ItemCategory> getItemCategories(){
		return itemCategoryDAO.findAll(ItemCategory.class);
	}
	
	
}