package com.masai;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buyer_id;
	private String name;
	private String email;
	private String mobile;
	@ManyToMany(mappedBy = "buyers")
	private List<Store> stores;

	public Buyer(String name, String email, String mobile, List<Store> stores) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.stores = stores;
	}

	public Buyer() {
		super();
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}
