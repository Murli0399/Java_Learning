package com.masai;

import javax.persistence.*;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findCustomerById", query = "SELECT c FROM Customer c WHERE c.customerId = :id")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String address;
	private int budget;

	public Customer() {
	}

	public Customer(int customerId, String name, String address, int budget) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.budget = budget;
	}

	public Customer(String name, String address, int budget) {
		this.name = name;
		this.address = address;
		this.budget = budget;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}

}
