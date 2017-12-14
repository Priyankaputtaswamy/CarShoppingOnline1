package com.nit.car.DaoImpl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.SupplierDao;
import com.nit.car.Model.Supplier;
@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao 
{
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public SupplierDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Supplier Supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(Supplier);
		return true;
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		
		
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
	}
			
			
		
	

	@Transactional
	public Supplier get(String sid) {
		String q1 = "from Supplier where sid='" + sid + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Supplier> list1 = (List<Supplier>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> Supplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Supplier;
	}

	

}
