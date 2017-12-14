package com.nit.car.DaoImpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.ProductDao;
import com.nit.car.Model.Product;



@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public ProductDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
				
		return true;
	}

	@Transactional
	public boolean delete(Product product) {
		
		
			sessionFactory.getCurrentSession().delete(product);
			return true;
	}
			
			
		
	

	@Transactional
	public Product get(String p_id) {
		String q1 = "from Product where p_id='" + p_id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Product> list1 = (List<Product>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> Product = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Product;
	}
	
//	@Transactional
//  public List<Product> getProductbyCategory(String cat_id)
//{
//String q1 = "from Product  where cat_id='" + cat_id + "'";
//	Query w = sessionFactory.getCurrentSession().createQuery(q1);
//	@SuppressWarnings("unchecked")
//	List<Product> list1 = (List<Product>) w.list();
//	if (list1 == null || list1.isEmpty()) {
//		return null;
//	} else {
//		return list1;
//	}
//}

@Transactional
public List<Product> getProductByCategory(String cat_id) {
	String q1 = "from Product  where cat_id='" + cat_id + "'";
	Query w = sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<Product> list1 = (List<Product>) w.list();
	if (list1 == null || list1.isEmpty()) {
		return null;
	} else {
		return list1;
	}
}

@Transactional
public List<Product> getProductBySupplier(String sid) {
	String q2 = "from Product  where sid='" + sid + "'";
	Query w = sessionFactory.getCurrentSession().createQuery(q2);
	@SuppressWarnings("unchecked")
	List<Product> list1 = (List<Product>) w.list();
	if (list1 == null || list1.isEmpty()) {
		return null;
	} else {
		return list1;
	}
}
}