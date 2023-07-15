package com.masai.problem01;

public class Product {
	private int productId;
	private String productName;
	private int price;
	private int quantity;

	Product() {

	}

	@Override
	public String toString() {
		return "Product Id = " + productId + ", Product Name = " + productName + ", Price = " + price + ", Quantity = "
				+ quantity + "\n";
	}

	public Product(int productId, String productName, int price, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
