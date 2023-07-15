package com.masai;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.HashSet;

public class Demo {

	static Pattern PAN_PATTERN = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
	static Pattern ADAHAR_PATTERN = Pattern.compile("^[0-9]{12}$");

	static boolean checkPAN(String PAN) {
		String pattern = "[A-Z]{5}\\d{4}[A-Z]";
		return Pattern.matches(pattern, PAN);
	}

	static boolean checkAdhaar(long adhaarNumber) {
		String pattern = "\\d{12}";
		return Pattern.matches(pattern, String.valueOf(adhaarNumber));
	}

	static boolean addTaxPayer(TaxPayer[] tpArr, TaxPayer newTP) {
		for (int i = 0; i < tpArr.length; i++) {
			if (newTP.equals(tpArr[i])) {
				return false;
			}
			for (int j = 0; j < tpArr.length; j++) {
				if (tpArr[j] == null) {
					tpArr[j] = newTP;
					break;
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Create an array of objects
		TaxPayer tpArr[] = new TaxPayer[5];
		int totalTaxPayers = 0;

		while (true) {
			System.out.print("Please enter name, PAN and adhaar Number ");
			String name = sc.next();
			String panNumber = sc.next();
			long adhaarNumber = sc.nextLong();
			if (checkPAN(panNumber) && checkAdhaar(adhaarNumber)) {
				// you are here means PAN and adhaar are in correct format
				if (addTaxPayer(tpArr, new TaxPayer(panNumber, adhaarNumber, name))) {
					// you are here means tax payer has added to the array
					System.out.println("Yahoo! Tax payer added\n");
					if (++totalTaxPayers == tpArr.length)
						// the array is full so better to break the loop
						break;
				} else {
					System.out.println("Tax Payer with this PAN & adhaar already exists\n");
				}
			} else {
				System.out.println("Enter correct PAN & adhaar number\n");
			}
		}

		System.out.println("Details of tax payers are as follow-");
		for (TaxPayer tp : tpArr)
			System.out.println(tp);
		sc.close();
	}

}
