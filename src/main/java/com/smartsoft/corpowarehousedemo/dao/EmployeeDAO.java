package com.smartsoft.corpowarehousedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartsoft.corpowarehousedemo.model.Employee;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class EmployeeDAO {
  @Autowired private SessionFactory sessionFactory;
   
  @Transactional
  public List<Employee> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List pizzas = session.createQuery("from Employee").list();
    return pizzas;
  }
}
