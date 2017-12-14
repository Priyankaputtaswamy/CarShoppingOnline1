package com.nit.car.DaoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.CartDao;
import com.nit.car.Model.Cart;

@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public CartDaoImpl(SessionFactory sessionFactory) 
	{

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Transactional
	public boolean delete(String c_id) {
		
		Cart cat = new Cart();
			cat.setC_id(c_id);
			System.out.println("object is set with data"+cat.getC_id());
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public Cart get(String c_id) {
		String q1 = "from Cart where c_id='" + c_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Cart> list1 = (List<Cart>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> Cart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Cart;
	}


}

