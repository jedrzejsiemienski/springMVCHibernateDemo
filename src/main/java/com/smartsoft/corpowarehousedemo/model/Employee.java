package com.smartsoft.corpowarehousedemo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
    @ManyToOne
    @JoinColumn(name="position_id")
	private Position position;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="employee")
	private Set<Possession> possessions;
    
    public long getId(){
    	return id;
    }
    
    public void setId(long id){
    	this.id = id;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Set<Possession> getPossessions(){
		return possessions;
	}
	
	public void setPossessions(Set<Possession> possessions){
		this.possessions = possessions;
	}
}