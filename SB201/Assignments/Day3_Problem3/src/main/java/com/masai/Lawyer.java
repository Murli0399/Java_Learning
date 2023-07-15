package com.masai;

import javax.persistence.*;

@Entity
public class Lawyer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String address;
	private int experience;

	public Lawyer() {
	}

	public Lawyer(String name, String email, String address, int experience) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.experience = experience;
	}

	public Lawyer(int id, String name, String email, String address, int experience) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Lawyer Id: " + id + ", Name: " + name + ", Email: " + email + ", Address: " + address + ", Experience: "
				+ experience;
	}

}
