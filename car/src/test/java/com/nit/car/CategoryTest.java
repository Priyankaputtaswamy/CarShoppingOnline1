package com.nit.car;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Model.Category;
import com.nit.car.Model.Product;




public class CategoryTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		Category category=(Category) context.getBean("category");
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		Product product=(Product) context.getBean("product");
		
	category.setCat_id("cat1");
	category.setCat_name("kjhbja");
	

	if(categoryDao.saveupdate(category)==true)
	{
			System.out.println("saved");
}
		else
	{
		System.out.println("sorry");
	}
	
//	Category cat=categoryDao.get("cat1");
//	List<Product> lists=productDao.getProductByCategory(cat.getCat_id());
//	if(lists==null||lists.isEmpty())
//	{
//		categoryDao.delete(cat);
//	}
//	else
//	{
//		for(Product p:lists)
//		{
//			productDao.delete(p);
//		}
//		categoryDao.delete(cat);
//		
//		}
//	}
	}
//	Category=categoryDao.get(
	
	
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
//			Category=categoryDao.get(
//			List<Product> p=productDao.getProductByCategory("");
//	}
	
	
	
}
