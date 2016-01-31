package com.smartsoft.corpowarehousedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartsoft.corpowarehousedemo.dao.ItemCategoryDAO;
import com.smartsoft.corpowarehousedemo.dao.ItemDAO;
import com.smartsoft.corpowarehousedemo.dao.PositionDAO;
import com.smartsoft.corpowarehousedemo.model.Item;
import com.smartsoft.corpowarehousedemo.model.ItemCategory;
import com.smartsoft.corpowarehousedemo.model.Position;

@Service
public class ItemsService {

	@Autowired private ItemDAO itemDAO;
	@Autowired private ItemCategoryDAO itemCategoryDAO;

	
	public ItemDAO getItemDAO() {
		return itemDAO;
	}
	
	public List<Item> getItems(){
		return itemDAO.findAll(Item.class);
	}
	
	public Item getItem(long id){
		return itemDAO.getById(Item.class, id);
	}
	
    public void addItem(Item entity) {
    	itemDAO.add(entity);
    }
 
    public void updateItem(Item entity) {
    	itemDAO.update(entity);
    }
    
    public void removeItem(long id) {
    	itemDAO.remove(Item.class, id);
    }
	
	
	
	public ItemCategoryDAO getItemCategoryDAO() {
		return itemCategoryDAO;
	}
	
	public List<ItemCategory> getItemCategories(){
		return itemCategoryDAO.findAll(ItemCategory.class);
	}
	
	public ItemCategory getItemCategory(long id){
		return itemCategoryDAO.getById(ItemCategory.class, id);
	}
	
    public void addItemCategory(ItemCategory entity) {
    	itemCategoryDAO.add(entity);
    }
 
    public void updateItemCategory(ItemCategory entity) {
    	itemCategoryDAO.update(entity);
    }
    
    public void removeItemCategory(long id) {
    	itemCategoryDAO.remove(ItemCategory.class, id);
    }
	
	
}