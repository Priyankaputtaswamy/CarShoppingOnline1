package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;

public interface CartItemDao
{
	public boolean saveupdate(CartItem cartItem);// true if successful else false
	// s returned

public boolean delete(String ci_id);
public CartItem get(String ci_id);
public List<CartItem> list(); // returns list of categories

public List<CartItem> getlist(String c_id);

public CartItem getListall(String c_id,String p_id);

 public List<CartItem> getListbyProduct(String p_id);

}

