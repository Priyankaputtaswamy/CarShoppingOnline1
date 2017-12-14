package com.nit.car.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.AuthenticationDao;
import com.nit.car.Model.Authentication;


@Repository("AuthenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao 
{
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public AuthenticationDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Transactional
	public boolean delete(Authentication authentication) {
		
		
			sessionFactory.getCurrentSession().delete(authentication);
			return true;
	}
			
			
		
	

	@Transactional
	public Authentication get(String roleId) {
		String q1 = "from Authentication where roleId='" + roleId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Authentication> list1 = (List<Authentication>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<Authentication> list() {
		@SuppressWarnings("unchecked")
		List<Authentication> Authentication = (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return Authentication;
	}

	

}

