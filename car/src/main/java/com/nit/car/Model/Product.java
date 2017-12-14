package com.nit.car.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
@Component
public class Product {
	
	private static final long SerialversionUID=1l;
	@Id
	private String p_id;
	private String p_name;
	private int p_quantity;
	private double p_price;
	private String p_description;
	
	@Transient
	private MultipartFile pimg;
	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Category C;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier sup;
	
	public Product()
	{
		this.p_id="P"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Category getC() {
		return C;
	}

	public void setC(Category c) {
		C = c;
	}

	public Supplier getSup() {
		return sup;
	}

	public void setSup(Supplier sup) {
		this.sup = sup;
	}

	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	public int getP_quantity() {
		return p_quantity;
	}

	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public String getP_description() {
		return p_description;
	}
	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
	
}
