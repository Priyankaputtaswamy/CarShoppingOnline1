package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Supplier;

public interface SupplierDao {
	public  boolean saveupdate(Supplier supplier);

public boolean delete(Supplier supplier);

public Supplier get(String sid); // returns a category given id

public List<Supplier> list(); // returns list of categories
}

