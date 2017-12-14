package com.nit.car.DaoImpl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.Model.Cart;
import com.nit.car.Model.User;
@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;//Reference variable 
 
	public UserDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveupdate(User user) {
		Cart cart=new Cart();
		user.setC(cart);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		sessionFactory.getCurrentSession().save(user.getC());
		//sessionFactory.getCurrentSession().saveOrUpdate(user.getBillingAddress());
		return true;
	}

	@Transactional
	public boolean delete(String uid) {
		
		User cat = new User();
			cat.setUid(uid);
			System.out.println("object is set with data"+cat.getUid());
			sessionFactory.getCurrentSession().delete(cat);
			return true;
	}
			
			
		
	

	@Transactional
	public User get(String uid) {
		String q1 = "from User where uid='" + uid + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User> list1 = (List<User>) w.list();
		if (list1 == null || list1.isEmpty()) {
			return null;
		} else {
			return list1.get(0);
		}

	}
	@Transactional
public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> User = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
     return User;
	}

public User isvalid(String email,String password)
{
	String q2 = "from User where email='"+email+"' password='"+password+"'";
	Query w = sessionFactory.getCurrentSession().createQuery(q2);
	@SuppressWarnings("unchecked")
	List<User> list2 = (List<User>) w.list();
	if (list2 == null || list2.isEmpty()) {
		return null;
	} else {
		return list2.get(0);
	}
}
@Transactional
public User email(String email) {
	String q3 = "from User where email='" + email + "'";
	Query w = sessionFactory.getCurrentSession().createQuery(q3);
	@SuppressWarnings("unchecked")
	List<User> list3 = (List<User>) w.list();
	if (list3 == null || list3.isEmpty()) {
		return null;
	} else {
		return list3.get(0);
	}

}
}

