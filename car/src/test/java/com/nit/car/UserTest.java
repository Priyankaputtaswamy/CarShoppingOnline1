package com.nit.car;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.UserDao;
import com.nit.car.Model.BillingAddress;
import com.nit.car.Model.Cart;
import com.nit.car.Model.User;


public class UserTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		UserDao userDao=(UserDao)context.getBean("userDao");
		User user=(User) context.getBean("user");
		BillingAddress b=(BillingAddress) context.getBean("billingAddress");
		Cart c=(Cart) context.getBean("cart");
		b.setB_city("blore");
		b.setB_locality("balor");
		b.setB_no("22");
		b.setB_pincode("001");
		b.setB_state("kar");
		b.setB_street("blore");
		
		c.setC_grandtotal(1001.00);
		c.setC_totalitems(100.00);
		
	user.setUname("priya");
	user.setAddress("punjab");
	user.setEmail("pp@gmail.com");
	user.setPhone("998889888");
user.setBillingAddress(b);
user.setC(c);


	if(userDao.saveupdate(user)==true)
	{
			System.out.println("saved");
}
		else
	{
		System.out.println("sorry");
	}
	
//		List<Category> list=categoryDao.list();
//		for(Category c:list){
//			System.out.println(c.getCat_id());
//			System.out.println(c.getCat_name());
//	
//		}
//	
//    if(categoryDao.delete("cat123")==true)
//    {
//    System.out.println("delete is successful");
//	}
//		else
//	{
//			System.out.println("sorry");
//      }
	}
}

