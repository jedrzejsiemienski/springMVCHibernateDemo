package com.smartsoft.corpowarehousedemo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "possessions")
public class Possession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
    @ManyToOne
    @JoinColumn(name="employee_id")
	private Employee employee;
	
    @ManyToOne
    @JoinColumn(name="item_id")
	private Item item;

    public long getId(){
    	return id;
    }
    
    public void setId(long id){
    	this.id = id;
    }
    
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}