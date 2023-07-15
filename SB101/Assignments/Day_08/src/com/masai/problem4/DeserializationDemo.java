package com.masai.problem4;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DeserializationDemo {
	public static void main(String[] args) throws ClassNotFoundException, IOException {

		Map<String, List<BallOfOver>> map = BallOperationsByRyan.getScoreList();
		String result = BallOperationsByRyan.findWinner(map);
		System.out.println(result);

	}
}
