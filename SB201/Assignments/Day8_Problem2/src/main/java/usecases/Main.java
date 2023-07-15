package usecases;

public class Main {
	public static void main(String[] args) {
		Game superContraGame = new SuperContraGame();
		Game pacManGame = new PacManGame();
		Game marioGame = new MarioGame();

		GameRunner gameRunner1 = new GameRunner(superContraGame);
		GameRunner gameRunner2 = new GameRunner(pacManGame);
		GameRunner gameRunner3 = new GameRunner(marioGame);

		gameRunner1.run();
		gameRunner2.run();
		gameRunner3.run();
	}
}
