package com.masai;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int store_id;
	private String store_name;
	private String location;

	@ManyToMany
	@JoinTable(name = "store_buyer", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "buyer_id"))
	private List<Buyer> buyers;
	@ManyToOne
	private Seller seller;

	public Store(String store_name, String location, List<Buyer> buyers, Seller seller) {
		this.store_name = store_name;
		this.location = location;
		this.buyers = buyers;
		this.seller = seller;
	}

	public Store() {
		super();
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Buyer> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

}
