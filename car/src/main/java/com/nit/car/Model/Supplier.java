package com.nit.car.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Supplier {
	
	
	@Id
	 private	String sid;
	 private	String sname;
	    private	String address;
	    
	    @OneToMany(mappedBy="sup")
	    List<Product> p;
	    
	    
	    
		public List<Product> getP() 
		{
			return p;
		}
		public Supplier()
		{
	    	this.sid="S"+UUID.randomUUID().toString().substring(30).toUpperCase();
	    }
		public void setP(List<Product> p) {
			this.p = p;
		}
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		

}
