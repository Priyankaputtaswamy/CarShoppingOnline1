package com.nit.car.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderItem {
	private String orderitem_id;
    public String getOrderitem_id() {
		return orderitem_id;
	}


	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}


	public String getP_id() {
		return p_id;
	}


	public void setP_id(String p_id) {
		this.p_id = p_id;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	private String p_id;
    
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
    private Order order;
	
    
    public OrderItem()
	{
		this.orderitem_id="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
   
    
}
