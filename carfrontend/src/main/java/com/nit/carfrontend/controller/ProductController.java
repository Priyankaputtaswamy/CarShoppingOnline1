package com.nit.carfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nit.car.Dao.ProductDao;
import com.nit.car.Model.Product;
import com.nit.fileinput.fileinput;

@Controller
public class ProductController {
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	String path="c:\\Users\\PRIYANKA\\workspace\\carfrontend\\src\\main\\webapp\\resources\\img\\";
	@RequestMapping(value="/Product",method=RequestMethod.POST)
	public ModelAndView Product(@ModelAttribute("product")Product product)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		
		if(productDao.saveupdate(product)==true)
		{
			fileinput.upload(path, product.getPimg(),product.getP_id()+".jpg");
			obj.addObject("msg1","product added successfully");
		}
		else
		{
			obj.addObject("msg2","product not added successfully");
		}
		
		return obj;
}
	@RequestMapping("/editproduct/{p_id}")
	public ModelAndView editproduct(@PathVariable("p_id")String p_id)
	{ 
	ModelAndView obj=new ModelAndView("product");
	product=productDao.get(p_id);
	List<Product> lp=productDao.list();
	obj.addObject("products",lp);
	obj.addObject("product",product);
	return obj;
}
	@RequestMapping("/deleteproduct/{p_id}")
	public ModelAndView deleteproduct(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		product=productDao.get(p_id);
		if(productDao.delete(product)==true)
		{
			obj.addObject("msg1","product deleted successfully");
		}
		else
		{
			obj.addObject("msg2","product not deleted successfully");
		}
	return obj;
}
}
