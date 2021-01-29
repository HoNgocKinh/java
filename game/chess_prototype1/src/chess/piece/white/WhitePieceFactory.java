package chess.piece.white;

import chess.piece.Piece;
import chess.piece.PieceAbstractFactory;
import chess.utils.ColorType;
import chess.utils.PieceType;

public class WhitePieceFactory extends PieceAbstractFactory {

	@Override
	public Piece buildPawn(int x, int y) {

		return new WhitePawn(x, y, ColorType.WHITE, PieceType.PAWN);
	}

	@Override
	public Piece buildKnight(int x, int y) {

		return new WhitePawn(x, y, ColorType.WHITE, PieceType.KNIGHT);
	}

	@Override
	public Piece buildRook(int x, int y) {

		return new WhiteRook(x, y, ColorType.WHITE, PieceType.ROOK);
	}

	@Override
	public Piece buildBishop(int x, int y) {

		return new WhiteBishop(x, y, ColorType.WHITE, PieceType.BISHOP);
	}

	@Override
	public Piece buildQueen(int x, int y) {
		
		return new WhiteQueen(x, y, ColorType.WHITE, PieceType.QUEEN);
	}

	@Override
	public Piece buildKing(int x, int y) {

		return new WhiteKing(x, y, ColorType.WHITE, PieceType.KING);
	}
	
}
