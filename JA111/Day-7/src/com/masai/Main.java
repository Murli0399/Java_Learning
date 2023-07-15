package com.masai;

public class Main {

	public static void main(String[] args) {
		FeeExpenses fe = new FeeExpenses(45000.0, 10.0);
		System.out.println("Total fee is " + fe.getTotalFee());
		FeeWithCess fc = new FeeWithCess(50000.0, 11.5, 2.5);
		System.out.println("Total fee is " + fc.getTotalFee());
	}

}
