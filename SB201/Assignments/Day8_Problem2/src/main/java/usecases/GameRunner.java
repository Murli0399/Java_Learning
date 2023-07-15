package usecases;

public class GameRunner {
	private Game game;

	public GameRunner(Game game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Game is started");
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
