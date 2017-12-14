package com.nit.car.DaoImpl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.ShippingaddressDao;
import com.nit.car.Model.Shippingaddress;

@Repository("shippingaddressDao")
@EnableTransactionManagement
public class ShippingaddressDaoImpl implements ShippingaddressDao{
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public ShippingaddressDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Shippingaddress shippingaddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingaddress
				);
		return true;
	}

	@Transactional
	public boolean delete(String s_id) {
		
		Shippingaddress cat = new Shippingaddress();
			cat.setS_id(s_id);
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public Shippingaddress get(String s_id) {
		String q1 = "from Shippingaddress where s_id='" + s_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list1 = (List<Shippingaddress>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Shippingaddress> list() {
		@SuppressWarnings("unchecked")
		List<Shippingaddress> shippingaddress = (List<Shippingaddress>) sessionFactory.getCurrentSession().createCriteria(Shippingaddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return shippingaddress;
	}

	@Override
	public List<Shippingaddress> getAddressByuser(String uid) {
		String q2 = "from Shippingaddress where s_id='" + uid + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list2 = (List<Shippingaddress>) w.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2;
		}
	}
}

