package com.masai.problem01;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product(1, "Mobile", 10000, 5));
		list.add(new Product(2, "T.V", 14000, 5));
		list.add(new Product(3, "Tablet", 6000, 12));
		list.add(new Product(4, "Laptop", 25500, 3));
		list.add(new Product(5, "Speaker", 2000, 14));

		list.forEach(System.out::print);

		System.out.println("-----------");
		list.stream().filter(i -> i.getQuantity()>10).sorted((i1,i2) -> i1.getPrice()>i2.getPrice()?1:-1).forEach(System.out::print);
		
	}
}
