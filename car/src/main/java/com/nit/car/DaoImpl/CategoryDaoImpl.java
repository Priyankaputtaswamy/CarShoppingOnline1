package com.nit.car.DaoImpl;



	import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

	import org.hibernate.Criteria;
	
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Model.Category;


	@Repository("categoryDao")
	@EnableTransactionManagement
	public class CategoryDaoImpl implements CategoryDao {
		@Autowired
		SessionFactory sessionFactory;//Reference variable 

		public CategoryDaoImpl(SessionFactory sessionFactory) {

			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public boolean saveupdate(Category category) {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		}

		@Transactional
		public boolean delete(Category category) {
			
			
				sessionFactory.getCurrentSession().delete(category);
				return true;
		}
				
				
			
		

		@Transactional
		public Category get(String id) {
			String q1 = "from Category where cat_id='" + id + "'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			@SuppressWarnings("unchecked")
			List<Category> list1 = (List<Category>) w.list();
			if (list1 == null || list1.isEmpty()) {
				return null;
			} else {
				return list1.get(0);
			}

		}
		@Transactional
	public List<Category> list() {
			@SuppressWarnings("unchecked")
			List<Category> category = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	     return category;
		}

	}


