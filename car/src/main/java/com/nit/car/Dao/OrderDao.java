package com.nit.car.Dao;

import java.util.List;

import javax.persistence.criteria.Order;

public interface OrderDao {

	public boolean saveupdate(Order order);  //true if succesful else false
	  
	  public boolean delete(String order_id);
	  
	  public Order get(String order_id);
	  
	  public List<Order> list();
	  //return list of cateogry
}
