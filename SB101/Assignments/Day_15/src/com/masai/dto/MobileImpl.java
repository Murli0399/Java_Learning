package com.masai.dto;

import java.time.LocalDate;

public class MobileImpl implements Mobile {
	private int id;
	private String model_no;
	private String company;
	private int price;
	private LocalDate mfgdate;

	public MobileImpl(String model_no, String company, int price, LocalDate mfgdate) {
		this.model_no = model_no;
		this.company = company;
		this.price = price;
		this.mfgdate = mfgdate;
	}

	public MobileImpl(int id, String model_no, String company, int price, LocalDate mfgdate) {
		this.id = id;
		this.model_no = model_no;
		this.company = company;
		this.price = price;
		this.mfgdate = mfgdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel_no() {
		return model_no;
	}

	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getMfgdate() {
		return mfgdate;
	}

	public void setMfgdate(LocalDate mfgdate) {
		this.mfgdate = mfgdate;
	}

}
