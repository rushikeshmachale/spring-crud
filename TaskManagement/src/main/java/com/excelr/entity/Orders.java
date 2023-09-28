package com.excelr.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numbers;
	private int orderId;
	private int pid;
	private int customerId;
	private String name;
	private int price;
	private String status;
	public Orders() {
		
	}
	public Orders(int numbers, int orderId, int pid, int customerId, String name, int price, String status) {
		super();
		this.numbers = numbers;
		this.orderId = orderId;
		this.pid = pid;
		this.customerId = customerId;
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

