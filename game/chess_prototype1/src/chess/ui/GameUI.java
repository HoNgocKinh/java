package chess.ui;

import java.util.List;

import javax.swing.JFrame;

import chess.piece.Piece;

public class GameUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 540;
	public static final int HEIGHT = 540;
	
	private BoardGameUI boardGameUI = null;
	
	public GameUI() {
		
		this.setTitle("Chess!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);
		this.setLayout(null);
	}
	
	public void openGamePlay() {
		
		this.setVisible(true);
	}
	
	public void draw(List<Piece> board) {
		openGamePlay();
		
		boardGameUI = BoardGameUI.getInstance(board);
		this.add(boardGameUI);
	}
}
