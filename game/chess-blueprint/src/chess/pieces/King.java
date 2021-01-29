package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class King extends Piece {

	private boolean castling = false;
	
	public King(int x, int y, Color color) {
		super(x, y, PieceType.KING, color);	
		this.value = 0;
	}
	
	public King() {
		
	}
	
	public void setCastling(boolean castling) {
		this.castling = castling;
	}
	
	public boolean isCastling() {
		
		return this.castling;
	}
	
}
