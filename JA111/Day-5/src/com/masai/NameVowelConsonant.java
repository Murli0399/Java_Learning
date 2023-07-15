package com.masai;

import java.util.Scanner;

public class NameVowelConsonant {
	static int getVowelCount(String name) {
		char[] str = name.toCharArray();
		int count = 0;
		for (char i : str) {
			if ((i == 'a') || (i == 'e') || (i == 'i') || (i == 'o') || (i == 'u')) {
				count++;
			}
		}
		return count;
	}

	static int getConsonentCount(String name) {
		char[] str = name.toCharArray();
		int count = 0;
		for (char i : str) {
			if ((i != 'a') && (i != 'e') && (i != 'i') && (i != 'o') && (i != 'u')) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
//		getVowelCount(name);
		System.out.println("Total Vowel in " + name + " is " + getVowelCount(name));
		System.out.println("Total Consonent in " + name + " is " + getConsonentCount(name));
	}
}

//Output
//murli
//Total Vowel in murli is 2
//Total Consonent in murli is 3