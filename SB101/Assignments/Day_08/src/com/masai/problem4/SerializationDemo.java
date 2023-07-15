package com.masai.problem4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SerializationDemo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<String, List<BallOfOver>> overs = new HashMap<>();
		List<BallOfOver> oversA = new ArrayList<>();
		List<BallOfOver> oversB = new ArrayList<>();

		BallOperationsByNitin obj = new BallOperationsByNitin();
		System.out.println("Enter ball by score for Team-A");
		obj.recordScores(oversA, sc);
		obj.recordScores(oversB, sc);

		overs.put("Team A", oversA);
		overs.put("Team B", oversB);

		obj.saveScores(overs);

	}
}
