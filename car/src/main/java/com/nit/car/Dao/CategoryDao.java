package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Category;


public interface CategoryDao {
	public boolean saveupdate(Category category);// true if successful else false
													// s returned

	public boolean delete(Category category);

	public Category get(String cat_id); // returns a category given id

	public List<Category> list(); // returns list of categories
}
