package com.nit.carfrontend.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.car.Dao.UserDao;
import com.nit.car.Model.User;
@Controller
public class LoginController {
@Autowired
User user;
@Autowired
UserDao userDao;

@RequestMapping("/sign")
public String login(@RequestParam(value="error",required=false)String error,
		@RequestParam(value="logout",required=false)String logout,Model model){
if(error!=null)
	model.addAttribute("error","invalid User name or password");
if(logout!=null)
	model.addAttribute("logout", "login seccessfull");
return "sign";
}

@RequestMapping(value="/j_spring_security_check")
public String processRegistration(@RequestParam("j_username")String email,@RequestParam("j_username")String password,
		 Model model,HttpSession session )
{
	System.out.println("sdfads");
	
	User u=userDao.isvalid(email, password);
	if(u==null)
	{
		System.out.println("kjhdfskj");
		 model.addAttribute("msg","Invalid user name and password");
    		return "redirect:/sign"; 
    }
	else 
	{
		 session.setAttribute("user", u);
		 session.setAttribute("name",u.getUname());
		 session.setAttribute("items",u.getC().getC_totalitems());
		 return "redirect:/sign"; 
	}
	
	
}

@RequestMapping(value= "/j_spring_security_logout")
public String logout(HttpServletRequest request, HttpSession Session, Model model){
	Session.invalidate();
	Session =request.getSession(true);
	model.addAttribute("logout", "logout successful");
	return "redirect:/";
}

}
