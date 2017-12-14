package com.nit.carfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.nit.car.Dao.UserDao;
import com.nit.car.Model.User;
@Controller
public class UserController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@RequestMapping(value="/User",method=RequestMethod.POST)
	public ModelAndView User(@ModelAttribute("user")User user1)
	{
		ModelAndView obj=new ModelAndView("redirect:/user");
		if(user1==null)
		{
			
			System.out.println("data is null");
			return obj;	
		}
		
		else
		{
		if(userDao.saveupdate(user1)==true)
		{
			obj.addObject("msg1","user added successfully");
		}
		else
		{
			obj.addObject("msg2","user not added successfully");
		}
		return obj;
		}
		
		
}
}