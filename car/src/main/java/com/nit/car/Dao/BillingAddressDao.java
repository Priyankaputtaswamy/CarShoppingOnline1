package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.BillingAddress;

public interface BillingAddressDao {
	public boolean saveupdate(BillingAddress billingAddress);// true if successful else false
	// s returned

public boolean delete(String b_id);

public BillingAddress get(String b_no); // returns a category given id

public List<BillingAddress> list(); 
public BillingAddress getByUser(String uid);// returns list of categories
}

