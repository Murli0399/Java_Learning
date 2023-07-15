package com.masai.problem3;

import java.io.Serializable;

public class Address implements Serializable {
	private String state;
	private String city;
	private int pincode;

	public Address(String state, String city, int pincode) {
		super();
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public int getPincode() {
		return pincode;
	}

}
