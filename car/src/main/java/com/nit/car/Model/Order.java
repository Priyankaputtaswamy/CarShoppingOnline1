package com.nit.car.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Order {

		private double orderno=0.0;
		private double grandtotal=0.0;
		
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="b_id")
		private BillingAddress BillingAddr;
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="s_id")
		private Shippingaddress shippingAddr;
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="pay_id")
		private Pay pay;
		
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="uid")
		private User user;
		
		@OneToMany(mappedBy="order",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private List<Order> orderitem;

		public double getOrderno() {
			return orderno;
		}

		public void setOrderno(double orderno) {
			this.orderno = orderno;
		}

		public double getGrandtotal() {
			return grandtotal;
		}

		public void setGrandtotal(double grandtotal) {
			this.grandtotal = grandtotal;
		}

		public BillingAddress getBillingAddr() {
			return BillingAddr;
		}

		public void setBillingAddr(BillingAddress billingAddr) {
			BillingAddr = billingAddr;
		}

		public Shippingaddress getShippingAddr() {
			return shippingAddr;
		}

		public void setShippingAddr(Shippingaddress shippingAddr) {
			this.shippingAddr = shippingAddr;
		}

		public Pay getPay() {
			return pay;
		}

		public void setPay(Pay pay) {
			this.pay = pay;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<Order> getOrderitem() {
			return orderitem;
		}

		public void setOrderitem(List<Order> orderitem) {
			this.orderitem = orderitem;
		}
		
		
	}

