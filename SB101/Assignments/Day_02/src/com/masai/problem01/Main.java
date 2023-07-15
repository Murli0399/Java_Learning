package com.masai.problem01;

@FunctionalInterface
interface Demo {
	public int convetStringToNumber(String s);
}

public class Main {

	public static void main(String[] args) {
		Demo d = Integer::parseInt;
		System.out.println(d.convetStringToNumber("15"));
	}
}
