package com.excelr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numbers;
	private int id;
	private int customerId;
	
	private String pname;
	private String pcatagory;
	private double price;
	
	public Cart() {
		
	}
	
	

	public Cart(int id,int numbers, int customerId, String pname, String pcatagory, double price) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.numbers = numbers;
		this.pname = pname;
		this.pcatagory = pcatagory;
		this.price = price;
	}



	public int getPid() {
		return id;
	}

	public void setPid(int id) {
		this.id = id;
	}
	
	

	public int getNumbers() {
		return numbers;
	}



	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcatagory() {
		return pcatagory;
	}

	public void setPcatagory(String pcatagory) {
		this.pcatagory = pcatagory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
