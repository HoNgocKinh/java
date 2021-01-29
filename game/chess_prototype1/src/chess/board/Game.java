package chess.board;

public class Game {
	
	public void start() {
		BoardGame board = BoardGame.getInstance();
		board.setUp();
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.start();
	}
}
