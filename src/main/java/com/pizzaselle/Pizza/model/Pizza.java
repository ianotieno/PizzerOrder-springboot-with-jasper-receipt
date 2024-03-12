package com.pizzaselle.Pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Pizza {

	
	public Pizza() {
		super();
	}
	public Pizza(Integer id, String productName, Integer price, Integer quantity, Integer total, Integer pay,
			Integer balance) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.pay = pay;
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ ", total=" + total + ", pay=" + pay + ", balance=" + balance + ", getId()=" + getId()
				+ ", getProductName()=" + getProductName() + ", getPrice()=" + getPrice() + ", getQuantity()="
				+ getQuantity() + ", getTotal()=" + getTotal() + ", getPay()=" + getPay() + ", getBalance()="
				+ getBalance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	private String productName;
	private Integer price;
	private Integer quantity;
	private Integer total;
	private Integer pay;
	private Integer balance;
}
