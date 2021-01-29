package chess.piece;

import chess.utils.PieceType;

public abstract class PieceAbstractFactory {
	
	public abstract Piece buildPawn(int x, int y);
	public abstract Piece buildKnight(int x, int y);
	public abstract Piece buildRook(int x, int y);
	public abstract Piece buildBishop(int x, int y);
	public abstract Piece buildQueen(int x, int y);
	public abstract Piece buildKing(int x, int y);
	
	public Piece getPiece(int x, int y, PieceType pieceType) {
		switch (pieceType) {
		case PAWN:
			return buildPawn(x, y);
		case KNIGHT:
			return buildKnight(x, y);
		case BISHOP:
			return buildBishop(x, y);
		case ROOK:
			return buildRook(x, y);
		case QUEEN:
			return buildQueen(x, y);
		case KING:
			return buildQueen(x, y);
		default: 
			return Piece.buildEmptySquare(x, y);
		}
	}
}
