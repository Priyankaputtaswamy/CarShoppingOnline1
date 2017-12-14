package com.nit.car.DaoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.BillingAddressDao;
import com.nit.car.Model.BillingAddress;

@Repository("BillingAddressDao")
@EnableTransactionManagement
public class BillingAddressDaoImpl implements BillingAddressDao 
{
	public boolean saveupdate(BillingAddress billingAddress) {
		// TODO Auto-generated method stub
		return false;
	}
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public BillingAddressDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public boolean delete(String b_id) {
		
		BillingAddress cat = new BillingAddress();
			cat.setB_id(b_id);
			System.out.println("object is set with data"+cat.getB_id());
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public BillingAddress get(String b_id) {
		String q1 = "from BillingAddress where b_id='" + b_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list1 = (List<BillingAddress>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	
	@Transactional
	public BillingAddress getbyUser(String uid) {
		String q2 = "from BillingAddress where uid='" + uid + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list2 = (List<BillingAddress>) w.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} else {
			return list2.get(0);
		}

	}
	@Transactional
public List<BillingAddress> list() {
		@SuppressWarnings("unchecked")
		List<BillingAddress> BillingAddress = (List<BillingAddress>) sessionFactory.getCurrentSession().createCriteria(BillingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return BillingAddress;
	}


	@Override
	public BillingAddress getByUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}


	

//	@Override
//	   public BillingAddress getByUser(String uid) 
//	{
//       TODO Auto-generated method stub
//		return null;
//	}


}

