package com.masai.problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("abc.txt");
		writer.write("9879798210\n");
		writer.write("1234567890\n");
		writer.write("8765432109\n");
		writer.write("2345678901\n");
		writer.write("7654321098\n");
		writer.write("6586586586\n");
		writer.write("6543210987\n");
		writer.write("4567890123\n");
		writer.write("5432109876\n");
		writer.write("5678901234\n");
		writer.close();

		BufferedReader bufferedReader = new BufferedReader(new FileReader("abc.txt"));
		FileWriter newWriter = new FileWriter("xyz.txt");
		String l1;
		while ((l1 = bufferedReader.readLine()) != null) {
			String number = l1.trim();
			if (number.matches("^[9|8|7|6]\\d{9}$")) {
				newWriter.write(number + "\n");
			}
		}
		bufferedReader.close();
		newWriter.close();

		BufferedReader r1 = new BufferedReader(new FileReader("abc.txt"));

		while ((l1 = r1.readLine()) != null) {
			System.out.println(l1);
		}
		r1.close();

		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		BufferedReader r2 = new BufferedReader(new FileReader("xyz.txt"));

		while ((l1 = r2.readLine()) != null) {
			System.out.println(l1);
		}
		r2.close();

	}
}
