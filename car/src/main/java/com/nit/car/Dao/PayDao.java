package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Pay;


public interface PayDao {
	public boolean saveupdate(Pay pay);// true if successful else false
	// s returned

public boolean delete(String pay_id);

public Pay get(String paymentmethod); // returns a category given id

public List<Pay> list(); // returns list of categories
}

