package com.smartsoft.corpowarehousedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseDAO<T> {
	@Autowired protected SessionFactory sessionFactory;
	
    @Transactional
    public void add(T entity) {
    	sessionFactory.getCurrentSession().save(entity);
    }
 
    @Transactional
    public void update(T entity) {
    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }
	
	@Transactional
	public List<T> findAll(Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		List results = session.createQuery("from " + type.getName()).list();
		return results;
	}
	
}
