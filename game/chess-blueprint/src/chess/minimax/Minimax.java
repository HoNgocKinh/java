package chess.minimax;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import chess.board.BoardService;
import chess.utils.Color;
import chess.utils.Move;
import javafx.util.Pair;

public class Minimax {
	
	Color color;
	int maxDepth;
	Random rand;
	BoardService boardService;
	
	public Minimax() {
		boardService = BoardService.getInstance();
	}
	
	public Pair<Point, Point> decision(Color color, int depth ) {
		
		List<Move> moves = boardService.getMoves(color);
		moves.forEach(System.out::println);

		return null;
	}
}
