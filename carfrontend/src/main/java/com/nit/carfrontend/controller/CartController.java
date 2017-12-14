package com.nit.carfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.car.Dao.CartDao;
import com.nit.car.Dao.CartItemDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.UserDao;

import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;
import com.nit.car.Model.Product;
import com.nit.car.Model.User;

@Controller 
public class CartController {


			@Autowired
			Product product;
			@Autowired 
			ProductDao productDao;
			
			@Autowired 
			User user;
			@Autowired 
			UserDao userDao;
			
			@Autowired
			Cart cart;
			@Autowired
			CartDao cartDao;
			
			@Autowired
			CartItem cartItem;
			@Autowired
			CartItemDao cartItemDao;
			
			@Autowired
			HttpSession session;
			
			@RequestMapping("/addtocart/{id}")
			public ModelAndView cart(@PathVariable("id") String id) 
			{
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (!(authentication instanceof AnonymousAuthenticationToken)) {
					String currusername = authentication.getName();
			User u = userDao.email(currusername);
			if (user == null)
			{
				return new ModelAndView("redirect:/");
			} 
			else
			{
				cart = u.getC();
				Product product1 = productDao.get(id);
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setP(product1);
				cartItem.setPrice(product1.getP_price());
				cartItemDao.saveupdate(cartItem);
				cart.setC_grandtotal(cart.getC_grandtotal() + product1.getP_price());
				cart.setC_totalitems(cart.getC_totalitems() + 1);
				cartDao.saveupdate(cart);
				session.setAttribute("items", cart.getC_totalitems());
				session.setAttribute("gd", cart.getC_grandtotal());
				return new ModelAndView("redirect:/");
				}
				}
				else {
					return new ModelAndView("redirect:/");
				}
			}
			
			@RequestMapping(value = "/viewcart")
			public String viewcart(Model model, HttpSession session) 
			{
				System.out.println(1223);
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (!(authentication instanceof AnonymousAuthenticationToken))
				{
					String currusername = authentication.getName();
					User u = userDao.email(currusername);
				        Cart c=u.getC();
						List<CartItem> cartItem = cartItemDao.getlist(u.getC().getC_id());
						if(cartItem==null ||cartItem.isEmpty())
						{
							session.setAttribute("items",0);
							model.addAttribute("gtotal",0.0);
							model.addAttribute("msg", "no Items is added to cart");
							return "viewcart";		
						}
						
						model.addAttribute("cartItems", cartItem);
						model.addAttribute("gtotal",c.getC_grandtotal());
						session.setAttribute("items",c.getC_totalitems());
					    session.setAttribute("cartId", c.getC_id());
						return "viewcart";		
			}
//				else
//				{
					return "redirect:/viewcart";
//				}
			}
			
			@RequestMapping(value="/Remove/{carId}")
			public ModelAndView RemoveFromCart(@PathVariable("carId") String id)
			{
				ModelAndView obj= new ModelAndView("redirect:/viewcart");
				cartItem=cartItemDao.get(id);
				Cart c=cartItem.getCart();
				c.setC_grandtotal(c.getC_grandtotal()-cartItem.getPrice());
				c.setC_totalitems(c.getC_totalitems()-1);
				cartDao.saveupdate(c);
				
				cartItemDao.delete(cartItem.getCi_id());
				return obj;
			}
			
			@RequestMapping(value="/Removeall")
			public String RemoveallFromCart(Model model,HttpSession session)
			{
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (!(authentication instanceof AnonymousAuthenticationToken))
				{
					String currusername = authentication.getName();
					User u = userDao.email(currusername);
				Cart c=cartDao.get(u.getC().getC_id());
				List<CartItem> cartItem=cartItemDao.getlist(u.getC().getC_id());
				for(CartItem g:cartItem)
				{
					cartItemDao.delete(g.getCi_id());
				}
				c.setC_grandtotal(0.0);;
				c.setC_totalitems(0.0);
				cartDao.saveupdate(c);
				session.setAttribute("items",c.getC_totalitems());
				return "redirect:/viewcart";
			}
				else
				{
					return "redirect:/";
				}
			}
			
//			@RequestMapping("/addtocartR/{p_id}")
//			public ModelAndView cartr(@PathVariable("p_id") String id) {
		//
//				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//				if (!(authentication instanceof AnonymousAuthenticationToken)) {
//					String currusername = authentication.getName();
//					User u = userDao.getUseremail(currusername);
//					if (user == null) {
//						return new ModelAndView("redirect:/");
//					} else {
		//
//						cart = u.getCart();
//						product = productDao.getProduct(id);
//						CartItems cartItem = new CartItems();
//						cartItem.setCart(cart);
//						cartItem.setProduct(product);
//						cartItem.setPrice(product.getP_c());
//						cartItemDao.saveOrUpdate(cartItem);
//						cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//						cart.setTotalitems(cart.getTotalitems() + 1);
//						cartDao.saveOrUpdate(cart);
//						session.setAttribute("items", cart.getTotalitems());
//						session.setAttribute("gd", cart.getGrandtotal());
//						return new ModelAndView("redirect:/viewcart");
//					}
//				} else {
//					return new ModelAndView("redirect:/");
//				}
		//
//			}
//			@RequestMapping("/addtocartC/{p_id}")
//			public ModelAndView cartc(@PathVariable("p_id") String id) {
		//
//				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//				if (!(authentication instanceof AnonymousAuthenticationToken)) {
//					String currusername = authentication.getName();
//					User u = userDao.getUseremail(currusername);
//					if (user == null) {
//						return new ModelAndView("redirect:/");
//					} else {
		//
//						cart = u.getCart();
//						product = productDao.getProduct(id);
//						CartItems cartItem = new CartItems();
//						cartItem.setCart(cart);
//						cartItem.setProduct(product);
//						cartItem.setPrice(product.getP_c());
//						cartItemDao.saveOrUpdate(cartItem);
//						cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//						cart.setTotalitems(cart.getTotalitems() + 1);
//						cartDao.saveOrUpdate(cart);
//						session.setAttribute("items", cart.getTotalitems());
//						session.setAttribute("gd", cart.getGrandtotal());
//						return new ModelAndView("redirect:/viewcart");
//					}
//				} else {
//					return new ModelAndView("redirect:/");
//				}
		//
//			}



	}


