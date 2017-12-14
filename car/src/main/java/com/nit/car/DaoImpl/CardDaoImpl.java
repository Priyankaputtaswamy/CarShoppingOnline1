package com.nit.car.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Model.Card;


public class CardDaoImpl {
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public CardDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);
		return true;
	}

	@Transactional	public boolean delete(String Card_id) {
		
		Card cat = new Card();
			cat.setCard_id(Card_id);
			System.out.println("object is set with data"+cat.getCard_id());
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public Card get(String card_id) {
		String q1 = "from Card where sid='" +card_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>)w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> Supplier = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Supplier;
	}


}

