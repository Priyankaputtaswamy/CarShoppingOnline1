package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.User;

public interface UserDao {
	public boolean saveupdate(User user);// true if successful else false
	// s returned

public boolean delete(String uid);

public User get(String uname); // returns a category given id
public User isvalid(String email,String password);
public List<User> list(); // returns list of categories
public User getEmail(String email);
}

