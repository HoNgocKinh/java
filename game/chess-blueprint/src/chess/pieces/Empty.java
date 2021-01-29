package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Empty extends Piece {
	
	private boolean isKingSafe = true;
	
	public Empty(int x, int y, Color color) {
		super(x, y, PieceType.EMPTY, Color.NONE);		
	}
	
	public Empty() {
		
	}
}
