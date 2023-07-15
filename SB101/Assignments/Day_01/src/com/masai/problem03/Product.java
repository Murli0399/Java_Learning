package com.masai.problem03;

public class Product {
	private int productId;
	private String productName;
	private int quantity;
	private int price;

	Product(){
		
	}
	
	Product(int productId, String productName, int quantity, int price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "productId=" + productId + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ "\n";
	}

}
