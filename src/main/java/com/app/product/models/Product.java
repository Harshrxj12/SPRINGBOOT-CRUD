package com.app.product.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_store")
public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Serial_ID")
 private int product_id;
 
@Column(name="Product_Label")
 private String product_name;
 
@Column(name="Owner_info")
 private String owner_name;
 
@Column(name="Product_MRP")
 private double product_price;


public int getProduct_id() {
	return product_id;
}


public void setProduct_id(int product_id) {
	this.product_id = product_id;
}


public String getProduct_name() {
	return product_name;
}


public void setProduct_name(String product_name) {
	this.product_name = product_name;
}


public String getOwner_name() {
	return owner_name;
}


public void setOwner_name(String owner_name) {
	this.owner_name = owner_name;
}


public double getProduct_price() {
	return product_price;
}


public void setProduct_price(double product_price) {
	this.product_price = product_price;
}
 

}
