package com.nit.car.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.OrderItemDao;
import com.nit.car.Model.Cart;
import com.nit.car.Model.OrderItem;

@Repository("OrderItemDao")
@EnableTransactionManagement
public class OrderItemDaoImpl implements OrderItemDao{
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public OrderItemDaoImpl(SessionFactory sessionFactory) 
	{

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(OrderItem orderitem) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderitem);
		return true;
	}

	@Transactional
	public boolean delete(String orderitem_id) {
		
		//OrderItem o = new OrderItem();
			//o.setOrderitem_id(orderitem_id);
			//System.out.println("object is set with data"+o.getOrderitem_id());
			sessionFactory.getCurrentSession().delete(orderitem_id);
			return true;
	}
			
			
		
	

	@Transactional
	public OrderItem get(String orderitem_id) {
		String q1 = "from orderItem where orderitem_id='" + orderitem_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItem> list1 = (List<OrderItem>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	
	
	@Transactional
	public List<OrderItem> getOrderItemByOrder(String orderno) {
		String q2 = "from orderItem where orderitem_id='" + orderno + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<OrderItem> list2 = (List<OrderItem>) w.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2;
		}

	}
	
	
	@Transactional
public List<OrderItem> list() {
		@SuppressWarnings("unchecked")
		List<OrderItem> OrderItem = (List<OrderItem>) sessionFactory.getCurrentSession().createCriteria(OrderItem.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return OrderItem;
	}

	


}

