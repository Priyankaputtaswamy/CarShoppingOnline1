package com.nit.car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.SupplierDao;
import com.nit.car.Model.Category;
import com.nit.car.Model.Product;
import com.nit.car.Model.Supplier;


public class ProductTest {
		public static void main(String args[]) {
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.nit.*");
			context.refresh();
			
			ProductDao productDao=(ProductDao)context.getBean("productDao");
			Product product=(Product) context.getBean("product");
			CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
			Category c=(Category) context.getBean("category");
			SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
			Supplier s=(Supplier) context.getBean("supplier");
			
			
			c=categoryDao.get("cat1");
			
				s=supplierDao.get("d234");
			product.setP_id("df2334");
			product.setP_name("hsg");
			product.setP_quantity(12);
			product.setP_price(12.0);
			product.setP_description("asdfg");
			product.setC(c);
			product.setSup(s);
			
			productDao.saveupdate(product);
		}
}
//		if(productDao.delete()==true)
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
//	{
//				System.out.println("sorry");
//	      }
//		}
//	}
//
