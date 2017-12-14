package com.nit.car.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Model.Pay;


public class PayDaoImpl {
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public PayDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay
				);
		return true;
	}

	@Transactional
	public boolean delete(String pay_id) {
		
		Pay cat = new Pay();
			cat.setPay_id(pay_id);
			System.out.println("object is set with data"+cat.getPay_id());
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public Pay get(String pay_id) {
		String q1 = "from Category where sid='" + pay_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list1 = (List<Pay>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Pay> list() {
		@SuppressWarnings("unchecked")
		List<Pay> Supplier = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Supplier;
	}


}

