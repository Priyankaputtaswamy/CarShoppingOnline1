
package com.nit.carfrontend.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nit.car.Dao.CategoryDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Model.Category;
import com.nit.car.Model.Product;

@Controller

public class CategoryController
{
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	@RequestMapping(value="/Category",method=RequestMethod.POST)
	public ModelAndView Category(@ModelAttribute("category")Category category)
	{
		ModelAndView obj=new ModelAndView("redirect:/category");
		
		if(categoryDao.saveupdate(category)==true)
		{
			obj.addObject("msg1","category added successfully");
		}
		else
		{
			obj.addObject("msg2","category not added successfully");
		}
		
		return obj;
		
	}
	@RequestMapping("/editcategory/{cat_id}")
	public ModelAndView edit(@PathVariable("cat_id")String cat_id)
	{
		ModelAndView obj=new ModelAndView("category");
		category=categoryDao.get(cat_id);
		List<com.nit.car.Model.Category> lc=categoryDao.list();
		obj.addObject("categorys",lc);
		obj.addObject("category",category);
		return obj;
	}
		@RequestMapping("/deleteCategory/{cat_id}")
		public ModelAndView delete(@PathVariable("cat_id")String cat_id)
		{
			ModelAndView obj=new ModelAndView("redirect:/category");
			category = categoryDao.get(cat_id);
			List<Product> list=productDao.getProductByCategory("category");
			if(list==null||list.isEmpty())
			{
				categoryDao.delete(category);
				obj.addObject("msg","category deleted successfully");
			}
			
			else
			{
				for(Product p:list)
				{
					productDao.delete(p);
				}
				categoryDao.delete(category);
				obj.addObject("msg1","category and list of product is been deleted");
				}
			
		return obj;
		}
		}
	


 