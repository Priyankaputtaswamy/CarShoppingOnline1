package com.nit.car.Dao;

import java.util.List;

import com.nit.car.Model.Card;

public interface CardDao {
	public boolean saveupdate(Card card);// true if successful else false
	// s returned

public boolean delete(String card_id);

public Card get(String card_no); // returns a category given id

public List<Card> list(); // returns list of categories
}

