package com.nit.carfrontend.controller;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.car.Dao.BillingAddressDao;
import com.nit.car.Dao.CardDao;
import com.nit.car.Dao.CartDao;
import com.nit.car.Dao.CartItemDao;
import com.nit.car.Dao.OrderDao;
import com.nit.car.Dao.OrderItemDao;
import com.nit.car.Dao.PayDao;
import com.nit.car.Dao.ProductDao;
import com.nit.car.Dao.ShippingaddressDao;
import com.nit.car.Dao.UserDao;
import com.nit.car.Model.BillingAddress;
import com.nit.car.Model.Card;
import com.nit.car.Model.Cart;
import com.nit.car.Model.CartItem;
import com.nit.car.Model.OrderItem;
import com.nit.car.Model.Pay;
import com.nit.car.Model.Product;
import com.nit.car.Model.Shippingaddress;
import com.nit.car.Model.User;

@Controller
public class OrderController {


	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItem cartItem;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	Card card;
	@Autowired
	CardDao cardDao;
	@Autowired
	BillingAddress billingAddress;
	@Autowired
	BillingAddressDao billingAddressDao;
	@Autowired
	Shippingaddress shippingaddress;
	@Autowired
	ShippingaddressDao shippingaddressDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItem orderItem;
	@Autowired
	OrderItemDao orderItemDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItem> cartItems;
	
	/*@Autowired
    private JavaMailSender mailSender;
	
	String o;*/
	

	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = userDao.getEmail(currusername);
			cart = user.getC();
			product=null;
			cartItems = cartItemDao.getlist(cart.getC_id());
			if(cartItems==null || cartItems.isEmpty())
			{
				return "redirect:/viewcart";
			}
			else
			{
				billingAddress = billingAddressDao.get(User.getUid());
				List<Shippingaddress> shippingaddresies = shippingaddressDao.getAddByuser(User.getUid());
				
				model.addAttribute("billing", billingAddress);
				model.addAttribute("user", user);
				model.addAttribute("shippingaddresies", shippingaddresies);
				model.addAttribute("shippingaddress", new Shippingaddress());
				session.setAttribute("p", product);
			}
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/Buy/{product_id}/{cartitem_id}")
	public String order(@PathVariable("product_id") String id, Model model,HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
			user = user1Dao.getEmail()(currusername);
			cart = User.getC();
			cartItem=null;
			product = productDao.getProduct(id);
			billingAddress = billingAddressDao.get(User.getUid());
			List<Shippingaddress> shippingaddresies = shippingaddressDao.getaddbyuser(user1.getU_Id());
			
			model.addAttribute("billingAddress", billingAddress);
			model.addAttribute("User", user);
			model.addAttribute("shippingaddresies", shippingaddresies);
			model.addAttribute("shippingaddress", new Shippingaddress());
			session.setAttribute("p", product);
			return "addressorder";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/orderConfirm")
	public String payment(@ModelAttribute("shippingAddress") Shippingaddress sh, Model model) {
//		if(cartItems==null || cartItems.isEmpty())
//		{
//			System.out.println("sorry");
//		}
		sh.setUser(user);
		shippingaddress = sh;
		model.addAttribute("billingAddress", billingAddress);
		model.addAttribute("shippingaddress", shippingaddress);
		model.addAttribute("prot", product);
		model.addAttribute("cartItems",cartItems);
		model.addAttribute("cart",cart);
		return "orderconfirm";
	}

	@RequestMapping("/previous")
	public String previous(Model model) {
		List<Shippingaddress> shippingAddresies = shippingaddressDao.getaddbyuser(user1.getUid());
		model.addAttribute("shippingAddresies", shippingAddresies);
		model.addAttribute("billingAddress", billingAddress);
		model.addAttribute("shippingaddress", shippingaddress);
		model.addAttribute("product", product);
		
		return "addressorder";
	}

	@RequestMapping("/pay")
	public String pay(Model model) {
//		List<Card> cards = cardDao.getcardbyuser(user.getUid());
//		model.addAttribute("cards", cards);
//		model.addAttribute("card", new Card());
		return "Payment";
	}

	@RequestMapping("/payment")
	public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
				
 		System.out.println(1324);
		int a;
		System.out.println(str);
				
		if (str.equalsIgnoreCase("Start Subscription")) {
			a = 2;
		} else {
			a = Integer.parseInt(str);
		}
		System.out.println(a);
		
		switch (a) {
		case 1:
				if(otp.equals(o))
				{
					pay.setPay_("COD");
					pay.setStatus("no");
				}
				else
				{
					return "redirect:/pay";
				}
			 
			break;
		case 2:
			pay.setPaymentmethod("card");
			pay.setPaymentmethod("yes");
			payDao.saveupdate(pay);
			cardDao.saveupdate(c);

			break;
		case 3:
			pay.setPaymentmethod("Internet Banking");
			pay.setPaymentmethod("yes");

		}

		return "redirect:/orderconfirmation";
	}

	@RequestMapping("/orderconfirmation")
	public String orderconformation(HttpSession session) {
		System.out.println(32);
		order.setBillingAddr(billingAddress);
		order.setShippingAddr(shippingaddress);
		order.setPay(pay);
		order.setUser(User);
		System.out.println(524);
		if (cartItems == null || cartItems.isEmpty()) 
		{
			order.setGrandtotal(product.getP_price());
			orderDao.saveupdate(order);
			orderItem.setOrder(Order);
			orderItem.setP_id(product.getP_id());
			orderItemDao.Saveupdate(orderItem);
			cart.setGrandtotal(cart.getc_grandtotal() - cartItem.getPrice());
			cart.setTotal_items(cart.getTotal_items() - 1);
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveupdate(cart);
			cartItemDao.delete(cartItemDao.getListall(cart.getC_id(),product.getP_id()).getCartitem_id());
			System.out.println(324);
		}
		else
		{ 
			System.out.println(656);
			order.setC_grandtotal(cart.getC_grandtotal());
			orderDao.saveupdate(order);
			for(CartItem c:cartItems)
			{
				System.out.println(3444);
				orderItem.setOrder(order);
				orderItem.setP_id(c.getProduct().getProduct_id());
				System.out.println(3443);
				orderItemsDao.Saveorupdate(orderItems);
				cartItemDao.delete(c.getCartitem_id());
			}
			cart.setGrandtotal(0.0);
			cart.setTotal_items(0);
			System.out.println(346);
			session.setAttribute("items", cart.getTotal_items());
			cartDao.saveCart(cart);
		}
		cartItems=null;
		cartItem=null;
		product=null;
		order=new Order();
		orderItems=new OrderItems();
		System.out.println(565);
		return "thankyou";
	}

@RequestMapping(value="/SendMail")
public void SendMail() {
	System.out.println(21312);
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
	String currusername = authentication.getName();
	user1 = user1Dao.getEmail(currusername);      
	Otpganarater ot=new Otpganarater();
//	String o=ot.Otpga();
	o=ot.Otpga();
	String recipientAddress = user1.getU_email();
	String subject="OTP";
//String subject = request.getParameter("subject");
String message = "your one time password is "+o+" ";

// prints debug info
System.out.println("To:" + recipientAddress);
System.out.println("Subject: " + subject);
System.out.println("Message: " + message);

    
//System.out.println("OTP:"+ otp);
// creates a simple e-mail object
SimpleMailMessage email = new SimpleMailMessage();
email.setTo(recipientAddress);
email.setSubject(subject);
email.setText(message);
//email.setSubject(otp);
// sends the e-mail
mailSender.send(email);

 
// forwards to the view named "Result"
//return "Result";
}
}
}
public class OrderController {

}
