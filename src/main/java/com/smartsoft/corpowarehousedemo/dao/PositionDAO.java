package com.smartsoft.corpowarehousedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartsoft.corpowarehousedemo.model.Position;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PositionDAO {
  @Autowired private SessionFactory sessionFactory;
   
  @Transactional
  public List<Position> findAll() {
    Session session = sessionFactory.getCurrentSession();
    List positions = session.createQuery("from Position").list();
    return positions;
  }
}
