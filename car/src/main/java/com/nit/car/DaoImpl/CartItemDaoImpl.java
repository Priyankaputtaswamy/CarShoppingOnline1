package com.nit.car.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.CartItemDao;
import com.nit.car.Model.CartItem;

@Repository("cartItemDao")
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public CartItemDaoImpl(SessionFactory sessionFactory) 
	{

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		return true;
	}

	@Transactional
	public boolean delete(CartItem cartItem) {
		
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
	}
			
			
		
	

	@Transactional
	public CartItem get(String ci_id) {
		String q1 = "from CartItem where ci_id='" + ci_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItem> list1 = (List<CartItem>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	
	
	@Transactional
	public List<CartItem> getListbyProduct(String p_id) {
		String q2 = "from CartItem where ci_id='" + p_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<CartItem> list2 = (List<CartItem>) w.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2;
		}

	}
	
	public List<CartItem> getlist(String c_id)
	{
		String q5 = "from CartItem where c_id='" + c_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q5);
		@SuppressWarnings("unchecked")
		List<CartItem> list3 = (List<CartItem>) w.list();
		if (list3 == null || list3.isEmpty()) {
			return null;
		} else {
			return list3;
		}
		
		
	}
	
	
	@Transactional
	public CartItem getListall(String c_id,String p_id) {
		String q2 = "from CartItem where c_id='" +c_id+ "' p_id='" +p_id+ "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<CartItem> list4 = (List<CartItem>) w.list();
		if (list4 == null || list4.isEmpty()) {
			return null;
		} else {
			return list4.get(0);
		}

	}
	@Transactional
public List<CartItem> list() {
		@SuppressWarnings("unchecked")
		List<CartItem> CartItem = (List<CartItem>) sessionFactory.getCurrentSession().createCriteria(CartItem.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return CartItem;
	}

	@Override
	public List<CartItem> getCartItemByCart(String c_id) {
		// TODO Auto-generated method stub
		String q3 = "from CartItem where c_id='" + c_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q3);
		@SuppressWarnings("unchecked")
		List<CartItem> list1 = (List<CartItem>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1;
		}
	}
	@Override
	public boolean delete(String ci_id) {
		// TODO Auto-generated method stub
		return false;
	}

}

