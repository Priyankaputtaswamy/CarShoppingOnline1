package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Authentication;


public interface AuthenticationDao {

	public boolean saveupdate(Authentication authentication);// true if successful else false
	// s returned

public boolean delete(Authentication authentication);

public Authentication get(String roleId); // returns a category given id

public List<Authentication> list(); //
}
