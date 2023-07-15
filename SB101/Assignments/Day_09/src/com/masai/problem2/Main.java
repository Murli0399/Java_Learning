package com.masai.problem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) throws IOException {

		Path file = Paths.get("car.txt");
		if (!Files.exists(file)) {
			Files.createFile(file);
		}
		byte[] bytes = "Ertiga 7 1200000 Toyota \nEon 5 475000 Hyundai \nCreta 5 1450000 Hyundai \nAlto 5 499000 Maruti \nFortuner 7 3450000 Toyota"
				.getBytes();

		Files.write(file, bytes);

		int sumOfAllCars = Files.lines(file).map(i -> i.split(" "))
				.mapToInt(i -> Integer.parseInt(i[1]) * Integer.parseInt(i[2])).sum();
		System.out.println("Sum of All Cars: " + sumOfAllCars);

		Files.lines(file).filter(i -> i.contains("Hyundai")).map(i -> i.split(" "))
				.forEach(i -> System.out.println(i[3] + " -> " + i[0]));
	}
}
