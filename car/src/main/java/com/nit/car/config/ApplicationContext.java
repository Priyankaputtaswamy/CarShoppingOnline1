package com.nit.car.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nit.car.Dao.BillingAddressDao;
import com.nit.car.Dao.CartDao;
import com.nit.car.Dao.CartItemDao;
import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.ShippingaddressDao;
import com.nit.car.Dao.SupplierDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.DaoImpl.BillingAddressDaoImpl;
import com.nit.car.DaoImpl.CartDaoImpl;
import com.nit.car.DaoImpl.CartItemDaoImpl;
import com.nit.car.DaoImpl.CategoryDaoImpl;
import com.nit.car.DaoImpl.ProductDaoImpl;
import com.nit.car.DaoImpl.ShippingaddressDaoImpl;
import com.nit.car.DaoImpl.SupplierDaoImpl;
import com.nit.car.DaoImpl.UserDaoImpl;
import com.nit.car.Model.BillingAddress;
import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;
import com.nit.car.Model.Category;
import com.nit.car.Model.Product;
import com.nit.car.Model.Shippingaddress;
import com.nit.car.Model.Supplier;
import com.nit.car.Model.User;
@Configuration
@ComponentScan("com.nit.*")
@EnableTransactionManagement
public class ApplicationContext {
	@Bean("dataSource")  //create a object without new keyword
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
//		Properties connectionProperties=new Properties();
//		connectionProperties.setProperty("hibernate.connection.pool_size", "10");
//		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//		connectionProperties.setProperty("hibernate.show_sql", "true");
//		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect");
	return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Shippingaddress.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
//	    sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("billingAddressDao")
	public BillingAddressDao getBillingAddressDao(SessionFactory sessionFactory)
	{
		return new BillingAddressDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("shippingaddressDao")
	public ShippingaddressDao getShippingaddressDao(SessionFactory sessionFactory)
	{
		return new ShippingaddressDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartItemDao")
	public CartItemDao getCartItemDao(SessionFactory sessionFactory)
	{
		return new CartItemDaoImpl(sessionFactory);
	}
}


