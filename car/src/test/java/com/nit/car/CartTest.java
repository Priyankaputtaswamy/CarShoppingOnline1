package com.nit.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.CartDao;
import com.nit.car.Dao.CartItemDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.Model.BillingAddress;
import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;
import com.nit.car.Model.Product;
import com.nit.car.Model.User;


public class CartTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");
		CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		CartItem cartItem=(CartItem) context.getBean("cartItem");
		UserDao userDao=(UserDao)context.getBean("userDao");
		User user=(User) context.getBean("user");
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		Product product=(Product) context.getBean("product");
	
	if(cartDao.saveupdate(cart)==true)
	{
		System.out.println("saved");
}
		else
	{
		System.out.println("sorry");
	}
	
	user=userDao.get("CD01B44");
cart=user.getC();
if(cart.getC_id()==null)
{
	System.out.println("not data existing");
}
else
{
	System.out.println("data existing");
}
////		List<Category> list=categoryDao.list();
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


