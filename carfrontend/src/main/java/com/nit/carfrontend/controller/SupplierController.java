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
import com.nit.car.Dao.SupplierDao;
import com.nit.car.Model.Product;
import com.nit.car.Model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;
	@RequestMapping(value="/Supplier",method=RequestMethod.POST)
	public ModelAndView Supplier(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		
		if(supplierDao.saveupdate(supplier)==true)
		{
			obj.addObject("msg1","supplier added successfully");
		}
		else
		{
			obj.addObject("msg2","supplier not added successfully");
		}
		
		return obj;
}
	@RequestMapping("/editsupplier/{sid}")
	public ModelAndView edit(@PathVariable("sid")String sid)
	{
		ModelAndView obj=new ModelAndView("supplier");
		supplier=supplierDao.get(sid);
		List<Supplier> ls=supplierDao.list();
		obj.addObject("suppliers",ls);
		obj.addObject("supplier",supplier);
		return obj;
	}
	@RequestMapping("/deleteSupplier/{sid}")
	public ModelAndView delete(@PathVariable("sid")String sid)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		supplier = supplierDao.get(sid);
		List<Product> list=productDao.getProductBySupplier("supplier");
		if(list==null||list.isEmpty())
		{
			supplierDao.delete(supplier);
			obj.addObject("msg","category deleted successfully");
		}
		
		else
		{
			for(Product p:list)
			{
				productDao.delete(p);
			}
			supplierDao.delete(supplier);
			obj.addObject("msg1","supplier and list of product is been deleted");
			}
		
	return obj;
}
}