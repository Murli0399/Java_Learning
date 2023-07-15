package com.masai;

public class Question2 {

	public static void main(String[] args) {
//		Write a program to check if a number is divisible by 11 or not such that you need to use following way to check divisibility
//		- If the difference between the sums of the alternate digits of the given number is either 0 or divisible by 11, then the number is divisible by 11.
		
		int a = 123322;
		
		if(a%11==0)
			System.out.println("Divisible");
		else
			System.out.println("Not Divisible");
		
	}
	
}
