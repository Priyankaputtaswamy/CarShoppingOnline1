package com.nit.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.ShippingaddressDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.Model.Shippingaddress;
import com.nit.car.Model.User;

public class ShippingaddressTest {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		ShippingaddressDao shippingaddressDao=(ShippingaddressDao)context.getBean("shippingaddressDao");
		Shippingaddress shippingaddress=(Shippingaddress) context.getBean("shippingaddress");
		UserDao userDao=(UserDao)context.getBean("userDao");
		User user=(User) context.getBean("user");
		user=userDao.get("CD01B44");
		
		shippingaddress.setS_street("mg");
		shippingaddress.setS_locality("blore");
		shippingaddress.setS_state("kartka");
		shippingaddress.setS_pincode("001");
	shippingaddress.setUser(user);
	

	if(shippingaddressDao.saveupdate(shippingaddress)==true)
	{
			System.out.println("saved");
}
		else
	{
		System.out.println("sorry");
	}
	}
}
//}
//	
//		List<Shippingaddress> list=shippingaddressDao.list();
//		for(ShippingAddress s:list){
//			System.out.println(c.getS_id());
//			System.out.println(c.getS_no());
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
//	}
//}
