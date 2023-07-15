package com.masai.problem4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

public class BallOperationsByRyan {

	public static Map<String, List<BallOfOver>> getScoreList() throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream("score.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Map<String, List<BallOfOver>> over = (Map<String, List<BallOfOver>>) in.readObject();
		in.close();
		fileIn.close();
		return over;
	}

	public static String findWinner(Map<String, List<BallOfOver>> map) {
		int runsA = 0;
		int runsB = 0;
		List<BallOfOver> scoreA = map.get("Team-A");
		List<BallOfOver> scoreB = map.get("Team-B");
		for (BallOfOver ball : scoreA) {
			runsA += ball.getRuns();
		}
		for (BallOfOver ball : scoreB) {
			runsB += ball.getRuns();
		}
		if (runsA > runsB) {
			return "Team-A won by " + (runsA - runsB) + " runs";
		} else if (runsB > runsA) {
			return "Team-B won by " + (runsB - runsA) + " runs";
		} else {
			return "Match Tied Finally";
		}
	}
}
