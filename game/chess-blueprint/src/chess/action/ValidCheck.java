package chess.action;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chess.board.BoardService;
import chess.pieces.King;
import chess.pieces.Piece;
import chess.pieces.Rook;
import chess.utils.Color;
import chess.utils.Move;
import chess.utils.PieceType;

public class ValidCheck implements Actionable {

	private Piece piece;
	private BoardService boardService = BoardService.getInstance();
	private Point location;
	
	public ValidCheck(Piece piece) {
		this.piece = piece;
		this.location = piece.getLocation();
	}

	public void move() {

		return;
	}

	public void check() {

		switch (piece.getPieceType()) {

		case PAWN: {
			pawnValid();
		}
			break;

		case ROOK: {
			rookValid();
		}
			break;

		case KNIGHT: {
			knightValid();
		}
			break;

		case BISHOP: {
			bishopValid();
		}
			break;

		case QUEEN: {
			queenValid();
		}
			break;

		case KING: {
			kingValid();
		}
			break;

		default:
			break;
		}
	}

	public void pawnValid() {

		// the pawn on the end line 
		List<Move> posibleMoves = Arrays.stream(piece.getMoves())
				.filter(isGreaterThan0AndLessThan8)
				.collect(Collectors.toList());
		
		if (posibleMoves.size() > 0) {
			Move forward1Step = posibleMoves.get(0);
			Move forward2Step = posibleMoves.size() > 1 ? posibleMoves.get(1) : null;
			// meanning the tile is occupied.
			boolean forward1StepStuck = boardService.getColor(forward1Step.getTo()) != Color.NONE;
			
			if (forward1StepStuck) {
				posibleMoves.remove(1);
				posibleMoves.remove(0);
			}
			else {
				if (forward2Step != null) {
					boolean forward2StepStuck = boardService.getColor(forward2Step.getTo()) != Color.NONE;
					if (forward2StepStuck) {
						posibleMoves.remove(forward2Step);
					}
				}
			}
		}
		
		int oriente = 1; // default is black will move down

		if (piece.getColor() == Color.WHITE) {
			oriente = -1;
		}

		boolean isCornerLeftOccupied = boardService.isOccupiedAt(piece.x + 1 * oriente, piece.y - 1);
		boolean isCornerRightOccupied = boardService.isOccupiedAt(piece.x + 1 * oriente, piece.y + 1);

		if (isCornerLeftOccupied) {
			// add new Corner left into posibleMoves
			Stream.of(new Move(location, new Point(piece.x + 1 * oriente, piece.y - 1)))
					.collect(Collectors.toCollection(() -> posibleMoves));
		}
		if (isCornerRightOccupied) {
			Stream.of(new Move(location, new Point(piece.x + 1 * oriente, piece.y + 1)))
					.collect(Collectors.toCollection(() -> posibleMoves));
		}

		
		Move[] moves = posibleMoves.stream()
				.filter(isGreaterThan0AndLessThan8)
				.filter(isNotSameColor)
				.toArray(Move[]::new);
		
		piece.setMoves(moves);
	}

	public void rookValid() {
		return;
	}

	private void knightValid() {

		List<Move> posibleMoves = Arrays.stream(piece.getMoves()).collect(Collectors.toList());
		
		Move[] moves =  posibleMoves.stream()
									.filter(isGreaterThan0AndLessThan8)
									.filter(isNotSameColor)
									.toArray(Move[]::new);

		piece.setMoves(moves);
	}

	private void bishopValid() {

		Move[] moves = Arrays.stream(piece.getMoves())
							 .filter(isGreaterThan0AndLessThan8)
							 .filter(isNotSameColor)
							 .toArray(Move[]::new);
		
		piece.setMoves(moves);
	}

	private void queenValid() {
		return;
	}

	private void kingValid() {

		List<Move> posibleMoves = Arrays.stream(piece.getMoves())
										.filter(isGreaterThan0AndLessThan8)
										.filter(isNotSameColor)
										.collect(Collectors.toList());
		
		King king = (King) piece;
		
		if (king.isCastling()) {
			
			List<Point> pointsFromKingToRightRook = Arrays.asList(
					new Point(piece.x, piece.y + 1),
					new Point(piece.x, piece.y + 2)
					);
			
			List<Point> pointsFromKingToLeftRook = Arrays.asList(
					new Point(piece.x, piece.y - 1),
					new Point(piece.x, piece.y - 2),
					new Point(piece.x, piece.y - 3)
					);
			
			boolean canCastlingRight = isCastling(pointsFromKingToRightRook , true); //is castling Right = true
			boolean canCastlingLeft = isCastling(pointsFromKingToLeftRook , false); //is castling Right = false
			
			if (canCastlingRight) {
				posibleMoves.add(new Move(location, new Point(piece.x, piece.y + 2)));
			}
			if (canCastlingLeft) {
				posibleMoves.add(new Move(location, new Point(piece.x, piece.y - 2)));
			}
		}
						
		Move[] moves = removeInvalidMovesFromKing(posibleMoves);
//		if (isCastling(pointsFromKingToRightRook, true)) { // castling to the right
//			posibleMoves.add(new Move(location, new Point(piece.x, piece.y + 2)));
//		}
//
//		if (isCastling(pointsFromKingToLeftRook, false)) { // castling to the left
//			posibleMoves.add(new Move(location, new Point(piece.x, piece.y - 2)));
//		}

		piece.setMoves(moves);
	}

	private Move[] removeInvalidMovesFromKing(List<Move> posibleMoves) {
				
		List<Move> kingMoves = posibleMoves.stream().collect(Collectors.toList());
		
		List<Move> safeMoves = boardService.getValidMoves(kingMoves, piece.getColor());
		
		return safeMoves.stream().toArray(Move[]::new);
	}
	
	private boolean isCastling(List<Point> pointsFromKingToRook, boolean isRightRook) {
		
		Predicate<Point> isNotOccupied = point -> {
			return boardService.getChessPiece(point.x, point.y) == PieceType.EMPTY;
		};
		
		boolean isEmptyAndSafeFromKing2Rook = pointsFromKingToRook
													.stream()
													.allMatch(isNotOccupied);
			
		Rook rook;
		Piece cornerPiece;
		int y;
		
		if (isRightRook) {
			y = piece.y + 3; // corner right.
		}
		else {
			y = piece.y - 4; // corner left.
		}
					
		cornerPiece = boardService.getPiece(piece.x, y);
			
		if (cornerPiece.getPieceType() == PieceType.ROOK && cornerPiece.getColor() == piece.getColor() ) { //king and rook same color!
				rook = (Rook) cornerPiece;
		}
		else {
			return false;
		}		
		
		// not allow rook or king moved in the early game!

		return !rook.isMoved() && isEmptyAndSafeFromKing2Rook;
	}
	
	private Predicate<Move> isNotSameColor = move -> {
		return boardService.getColor(move.getTo()) != piece.getColor();
	};
	
	private Predicate<Move> isNotOccupiedTile = (move) -> {
		return !boardService.isOccupiedAt(move.getTo().x, move.getTo().y);
	};

	private Predicate<Move> isGreaterThan0AndLessThan8 = (move) -> {
		return move.getTo().x >= 0 && move.getTo().y >= 0 && move.getTo().x < 8 && move.getTo().y < 8;
	};
}
