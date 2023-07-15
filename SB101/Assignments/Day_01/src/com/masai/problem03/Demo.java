package com.masai.problem03;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1, "Mobile", 2, 10000));
		productList.add(new Product(2, "T.V.", 5, 50000));
		productList.add(new Product(3, "Laptop", 3, 150000));
		productList.add(new Product(4, "Speaker", 2, 5000));
		productList.add(new Product(5, "Desktop", 1, 100000));

		productList.sort((p1, p2) -> p2.getPrice() - p1.getPrice());

		System.out.println(productList);
	}
}
