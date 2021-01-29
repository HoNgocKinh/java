package chess.minimax;

import java.awt.Point;

import chess.utils.Color;
import javafx.util.Pair;

public class AIPlayer {
	
	public static final int SMART_LEVEL = 2; //from 1 -> 6
	
	Color color = Color.BLACK;
	Minimax minimax;
	
	public AIPlayer() {
		minimax = new Minimax();
	}
	
	
	public Pair<Point, Point> getNextMoves(Color color) {
		
		return minimax.decision(color, SMART_LEVEL);
	}
}
