package com.nit.car.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItem {
	private static final long SerialversionUID=1l;
	@Id
	private String ci_id;
	 double price;
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="p_id")
	private Product p;
	
	@ManyToOne
	@JoinColumn(name="c_id")
	Cart cart;
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Product getP() {
		return p;
	}


	public void setP(Product p) {
		this.p = p;
	}


	public CartItem()
	{
    	this.ci_id="B"+UUID.randomUUID().toString().substring(30).toUpperCase();
    }
	
	
	public String getCi_id() 
	{
		return ci_id;
	}
	public void setCi_id(String ci_id) 
	{
		this.ci_id = ci_id;
	}
}
