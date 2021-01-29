package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Pawn extends Piece {
	
	public boolean isPawnFirstTimeMove = true;
	
	
    public Pawn(int x, int y, Color color) {
    	
        super(x, y, PieceType.PAWN, color);
        this.value = 1;
    }
    public Pawn() {
    	
    }
        
}
