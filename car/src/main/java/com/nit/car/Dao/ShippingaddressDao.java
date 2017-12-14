package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Shippingaddress;

public interface ShippingaddressDao {
	public boolean saveupdate(Shippingaddress shippingaddress);// true if successful else false
	// s returned

public boolean delete(String s_id);

public Shippingaddress get(String s_no); // returns a category given id

public List<Shippingaddress> list();
public List<Shippingaddress>   getAddByuser(String uid);// returns list of categories
}

