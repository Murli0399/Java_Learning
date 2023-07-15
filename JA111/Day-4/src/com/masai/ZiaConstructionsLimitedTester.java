package com.masai;

import java.util.Scanner;

public class ZiaConstructionsLimitedTester {
	public static void main(String args[]) {
		ZiaConstructionsLimited zcl = new ZiaConstructionsLimited();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Zia constructions limited");
		System.out.println("Enter you construction area in per square feets");
		double x = sc.nextDouble();
		System.out.println("Do you want to take material also [y/n]:");
		String ans = sc.next();
		if (ans.equals("y")) {
			System.out.println(zcl.getTotalCost(x, 250, 350));
		} else {
			System.out.println(zcl.getTotalCost(x, 250));
		}
	}
}
