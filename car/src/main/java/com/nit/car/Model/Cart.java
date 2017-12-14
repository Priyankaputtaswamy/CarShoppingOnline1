package com.nit.car.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	private static final long SerialversionUID=1l;
	@Id
	private String c_id;
	private double c_grandtotal=0.0;
	private double c_totalitems=0.0;
	
	 @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="uid")
	  private  User user;
	 
	@OneToMany(mappedBy="cart")
	List<CartItem> ca;
	
	public List<CartItem> getCa() {
		return ca;
	}

	public void setCa(List<CartItem> ca) {
		this.ca = ca;
	}

	public Cart()
	{
    	this.c_id="B"+UUID.randomUUID().toString().substring(30).toUpperCase();
    }

	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Double getC_grandtotal() {
		return c_grandtotal;
	}
	public void setC_grandtotal(Double c_grandtotal) {
		this.c_grandtotal = c_grandtotal;
	}
	public Double getC_totalitems() {
		return c_totalitems;
	}
	public void setC_totalitems(Double c_totalitems) {
		this.c_totalitems = c_totalitems;
	}
}
