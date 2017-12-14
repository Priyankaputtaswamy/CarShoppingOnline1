package com.nit.car.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User {
	private static final long SerialversionUID=1l;
	@Id
	 private	String uid;
	    private	String uname;
	    private	String password;
	    private	String address;
	    private	String email;
	    private	String phone;

	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="b_id")
	  private  BillingAddress billingAddress;
	    
	    
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="C_id")
	  private  Cart c;
	    
	    @OneToMany(mappedBy="user")
	    private List<Shippingaddress> shippingaddress;
	    
		public List<Shippingaddress> getShippingaddress() {
			return shippingaddress;
		}
		public void setShippingaddress(List<Shippingaddress> shippingaddress) {
			this.shippingaddress = shippingaddress;
		}
		public Cart getC() {
			return c;
		}
		public void setC(Cart c) {
			this.c = c;
		}
		public User(){
	    	this.uid="U"+UUID.randomUUID().toString().substring(30).toUpperCase();
	    }
		
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPassword() {
			return password;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public BillingAddress getBillingAddress() {
			return billingAddress;
		}
		public void setBillingAddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}
		
	    
}
