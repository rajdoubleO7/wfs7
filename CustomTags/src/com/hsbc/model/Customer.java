package com.hsbc.model;

public class Customer {
	private int customerID;
	private String name;
	private int age;
	private String address;
	public Customer(int customerID, String name, int age, String address) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Customer() {
		super();
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
