package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Rook extends Piece {

	private boolean moved = false;
	
	public Rook(int x, int y, Color color) {
		super(x, y, PieceType.ROOK, color);
		this.value = 5;
	}
	
	public Rook() {
		
	}
	
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
	public boolean isMoved() {
		return moved;
	}
	
}
