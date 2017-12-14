package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.OrderItem;

public interface OrderItemDao {
public boolean saveupdate(OrderItem orderitem);
public boolean delete(String orderitem_id);
public OrderItem get(String orderitem_id);
public List<OrderItem> getOrderItembyOrder(String orderno);
public List<OrderItem> list();
}
