package com.nit.car;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.SupplierDao;
import com.nit.car.Model.Product;
import com.nit.car.Model.Supplier;

public class SupplierTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.nit.*");
		context.refresh();
		
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		Supplier supplier=(Supplier) context.getBean("supplier");
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		Product product=(Product) context.getBean("product");
	supplier.setSid("S6A7E9C");
	supplier.setSname("rwer");
supplier.setAddress("adfghr123");
	if(supplierDao.saveupdate(supplier)==true)
	{
			System.out.println("saved");
}
		else
	{
		System.out.println("sorry");
	}
	
	
	
	Supplier sup=supplierDao.get("a333");
	List<Product> lists=productDao.getProductBySupplier(sup.getSid());
	if(lists==null||lists.isEmpty())
	{
		supplierDao.delete(sup);
	}
	else
	{
		for(Product pa:lists)
		{
			productDao.delete(pa);
		}
		supplierDao.delete(sup);
		
		}
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
