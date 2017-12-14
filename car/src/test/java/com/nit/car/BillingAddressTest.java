package com.nit.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.BillingAddressDao;
import com.nit.car.Model.BillingAddress;

public class BillingAddressTest {
		public static void main(String args[]) {
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.nit.*");
			context.refresh();
			
			BillingAddressDao BillingAddressDao=(BillingAddressDao)context.getBean("billingAddressDao");
			BillingAddress billingAddress=(BillingAddress) context.getBean("billingAddress");
			billingAddress.setB_id("001");
			billingAddress.setB_no("113");
			billingAddress.setB_street("for");
			billingAddress.setB_locality("raj");
			billingAddress.setB_city("blor");
			billingAddress.setB_state("karnataka");
			billingAddress.setB_pincode("001");
		}
}
			
		

//		if(BillingAddressDao.saveupdate(billingAddress)==true)
//		{
//				System.out.println("saved");
//	}
//			else
//		{
//			System.out.println("sorry");
//		}
//		
//			List<Category> list=categoryDao.list();
//			for(Category c:list){
//				System.out.println(c.getCat_id());
//				System.out.println(c.getCat_name());
	//	
//			}
	//	
//	    if(categoryDao.delete("cat123")==true)
//	    {
//	    System.out.println("delete is successful");
//		}
//			else
//		{
//				System.out.println("sorry");
//	      }
