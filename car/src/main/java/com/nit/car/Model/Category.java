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
public class Category 
{
	private static final long SerialversionUID=1l;
	@Id
    private	String cat_id;
    private	String cat_name;
    @OneToMany(mappedBy="C")
     List<Product> p;
    
    public List<Product> getP() {
		return p;
	}

	public void setP(List<Product> p) {
		this.p = p;
	}

	public Category(){
    	this.cat_id="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
    }
    
    
public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
}
