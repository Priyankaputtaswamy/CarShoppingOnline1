package com.nit.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.CartDao;
import com.nit.car.Dao.CartItemDao;
import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;
import com.nit.car.Model.Product;


public class CartItemTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		CartItem cartItem=(CartItem) context.getBean("cartItem");
	
		
		Product product=(Product) context.getBean("product");
		product.setP_name("hsg");
		product.setP_quantity(12);
		product.setP_price(12.0);
		product.setP_description("asdfg");
        cartItem.setP(product);
    
        CartDao cartDao=(CartDao)context.getBean("cartDao");
		Cart cart=(Cart) context.getBean("cart");
		cart=cartDao.get("B59C97F");
			cartItem.setCart(cart);	
		
	if(cartItemDao.saveupdate(cartItem)==true)
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
