package chess.piece;

import chess.utils.ColorType;
import chess.utils.PieceType;

public class Piece {
	
	public int x;
	public int y;
	public ColorType color;
	public PieceType type;
	
	public Piece(int x, int y, ColorType color, PieceType type) {
		this.x = x;
		this.type = type;
		this.y = y;
		this.color = color;
	}
	
	public static Piece buildEmptySquare(int x, int y) {
		return new EmptyPiece(x, y, ColorType.NONE, PieceType.NONE);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
	}

	public PieceType getType() {
		return type;
	}

	public void setType(PieceType type) {
		this.type = type;
	}
	
}
