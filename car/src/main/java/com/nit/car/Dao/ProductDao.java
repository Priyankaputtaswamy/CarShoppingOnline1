package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Product;

public interface ProductDao {
	public boolean saveupdate(Product product);// true if successful else false
	// s returned

public boolean delete(Product product);

public Product get(String p_id); // returns a category given id

public List<Product> list(); // returns list of categories
public List<Product>getProductByCategory(String cat_id);//taking info of category by passing cat_id//
public List<Product>getProductBySupplier(String sid);

}

