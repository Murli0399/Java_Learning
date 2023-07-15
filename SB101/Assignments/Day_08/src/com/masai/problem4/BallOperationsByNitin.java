package com.masai.problem4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BallOperationsByNitin {
	public static void recordScores(List<BallOfOver> scoreList, Scanner sc) {
		int i = 0;
		while (i < 6) {
			System.out.println("Enter run scored on this ball");
			int runs = sc.nextInt();
			System.out.println("Is it a valid ball (y/n)");
			char isFairDelivery = sc.next().charAt(0);
			scoreList.add(new BallOfOver(runs, isFairDelivery));
			if (isFairDelivery == 'y') {
				i++;
			}
		}
	}

	public static void saveScores(Map<String, List<BallOfOver>> overs) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("score.ser"));
		oos.writeObject(overs);
		oos.close();
	}
}
