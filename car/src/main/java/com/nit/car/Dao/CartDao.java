package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Cart;

public interface CartDao {
	public boolean saveupdate(Cart cart);// true if successful else false
	// s returned

public boolean delete(String c_id);

public Cart get(String c_id); // returns a category gi
public List<Cart> list(); // returns list of categories

}
