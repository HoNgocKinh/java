package chess.utils.helper;

import java.awt.Point;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import chess.piece.Piece;
import chess.ui.BoardGameUI;
import chess.utils.PieceType;

public class BoardHelper {
	
	private List<Piece> board;
	
	public BoardHelper(List<Piece> board) {
		this.board = board;
	}
	
	public Predicate<Point> IS_OCCUPIED_AND_SAME_COLOR = (p) -> {
		
		return false;
	};
	
	public Optional<Piece> findPieceAtLocation(Point location) {
		return Optional.ofNullable(board.stream()
				.filter(p -> p.getX() == location.getX() && p.getY() == location.getY())
				.findFirst()
				.filter(IS_EMPTY_SQUARE.negate())
				.orElseGet(() -> null));
	}
	
	public Predicate<Piece> IS_EMPTY_SQUARE = (p) -> {
		return p.getType() == PieceType.NONE;
	};
	
	public Predicate<Point> OUT_OF_RANGE = (p) -> {
		return p.x >= BoardGameUI.MAX_SQUARE || p.y >= BoardGameUI.MAX_SQUARE || p.x < 0 || p.y < 0; 
	};
}
