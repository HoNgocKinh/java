package chess.piece.black;

import chess.piece.Piece;
import chess.piece.PieceAbstractFactory;
import chess.utils.ColorType;
import chess.utils.PieceType;

public class BlackPieceFactory extends PieceAbstractFactory {

	@Override
	public Piece buildPawn(int x, int y) {
		
		return new BlackPawn(x, y, ColorType.BLACK, PieceType.PAWN);
	}

	@Override
	public Piece buildKnight(int x, int y) {

		return new BlackKnight(x, y, ColorType.BLACK, PieceType.KNIGHT);
	}

	@Override
	public Piece buildRook(int x, int y) {
		
		return new BlackRook(x, y, ColorType.BLACK, PieceType.ROOK);
	}

	@Override
	public Piece buildBishop(int x, int y) {
		
		return new BlackBishop(x, y, ColorType.BLACK, PieceType.BISHOP);
	}

	@Override
	public Piece buildQueen(int x, int y) {

		return new BlackQueen(x, y, ColorType.BLACK, PieceType.QUEEN);
	}

	@Override
	public Piece buildKing(int x, int y) {

		return new BlackKing(x, y, ColorType.BLACK, PieceType.KING);
	}
}
