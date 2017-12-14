package com.nit.carfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.SupplierDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.Model.BillingAddress;
import com.nit.car.Model.Category;
import com.nit.car.Model.Product;
import com.nit.car.Model.Supplier;
import com.nit.car.Model.User;

@Controller
public class HomeController 
{
	@Autowired
	CategoryDao categoryDao;
	Category category;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@RequestMapping("/")
  public String homepage()
  {
	  return "car";
  }
	@RequestMapping("/home")
  public ModelAndView home()
  {
	  return new ModelAndView("car");
  }
	@RequestMapping("/category")
	public ModelAndView category()
	{
		ModelAndView obj=new ModelAndView("category");
	obj.addObject("category",new Category());
	List<Category> lc=categoryDao.list();
	obj.addObject("categorys",lc);
	return obj;
}
	@RequestMapping("/contact")
	  public String contact()
	  {
		  return "contact";
	  }

	@RequestMapping("/about")
	  public String about()
	  {
		  return "about";
	  }

	@RequestMapping("/image1")
	  public String image1()
	  {
		  return "image1";
	  }

	@RequestMapping("/image2")
	  public String image2()
	  {
		  return "image2";
	  }

	@RequestMapping("/image3")
	  public String image3()
	  {
		  return "image3";
	  }

	@RequestMapping("/bs")
  public String bs()
	  {
		  return "bs";
	  }
	@RequestMapping("/table")
	  public String table()
		  {
			  return "table";
		  }
		
	@RequestMapping("/viewcart")
	  public String viewcart()
	  {
		  return "viewcart";
	  }

	@RequestMapping("/supplier")
	public ModelAndView supplier()
	{
		ModelAndView obj=new ModelAndView("supplier");
	obj.addObject("supplier",new Supplier());
	List<Supplier> ls=supplierDao.list();
	obj.addObject("suppliers",ls);
	return obj;
	}

	@RequestMapping("/product")
	public ModelAndView product()
	{
		ModelAndView obj=new ModelAndView("product");
	obj.addObject("product",new Product());
	List<Product> lp=productDao.list();
	obj.addObject("products",lp);
	return obj;
	}
	@RequestMapping("/user")
	public ModelAndView user()
	{
		ModelAndView obj=new ModelAndView("user");
		BillingAddress bat = new BillingAddress();
		user.setBillingAddress(bat);
	obj.addObject("user",user);
	List<User> lu=userDao.list();
	obj.addObject("users",lu);
	return obj;
	}
}