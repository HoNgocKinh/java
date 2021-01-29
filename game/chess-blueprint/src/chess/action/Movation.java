package chess.action;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import chess.board.BoardService;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.utils.Color;
import chess.utils.Move;

public class Movation implements Actionable {

	private Piece piece;
	private BoardService boardService = BoardService.getInstance();

	public Movation(Piece piece) {

		this.piece = piece;
	}

	public void move() {

		switch (this.piece.getPieceType()) {
		case PAWN: {
			pawnMoves();
		}
			break;

		case ROOK: {
			rookMoves();
		}
			break;

		case KNIGHT: {
			knightMoves();
		}
			break;

		case BISHOP: {
			bishopMoves();
		}
			break;

		case QUEEN: {
			queenMoves();
		}
			break;

		case KING: {
			kingMoves();
		}
			break;

		default:
			break;
		}

	}

	private void pawnMoves() {

		int oriente = 1; // default is black will move down

		if (piece.getColor() == Color.WHITE) {
			oriente = -1;
		}

		Move forward1Step = new Move(piece.getLocation(), new Point(piece.x + 1 * oriente, piece.y));
		Move forward2Step = new Move(piece.getLocation(), new Point(piece.x + 2 * oriente, piece.y));

		List<Move> moves;

		Pawn pawn = (Pawn) piece;

		if (pawn.isPawnFirstTimeMove) {

			moves = Arrays.asList(forward1Step, forward2Step);
		} else {
			moves = Arrays.asList(forward1Step);
		}

		piece.setMoves(moves.stream().toArray(Move[]::new));
	}

	private Move[] rookMoves() {

		List<Move> moves = new ArrayList<Move>();

//		col from y to 8
		for (int y = piece.y + 1; y < 8; y++) {

			if (boardService.isOccupiedAt(piece.x, y)) {	
				moves.add(new Move(piece.getLocation(), new Point(piece.x, y)));
				break;
			}
							
			moves.add(new Move(piece.getLocation(), new Point(piece.x, y)));
		}
//		row from x to 8
		for (int x = piece.x + 1; x < 8; x++) {
			if (boardService.isOccupiedAt(x, piece.y)) {
				
				moves.add(new Move(piece.getLocation(), new Point(x, piece.y)));
				break;
			}
				
			moves.add(new Move(piece.getLocation(), new Point(x, piece.y)));
		}

//		col from y to 0
		for (int y = piece.y - 1; y >= 0; y--) {
			if (boardService.isOccupiedAt(piece.x, y)) { 
				moves.add(new Move(piece.getLocation(), new Point(piece.x, y)));
				break;
			}
			
			moves.add(new Move(piece.getLocation(), new Point(piece.x, y)));
		}
//		row from x to 0
		for (int x = piece.x - 1; x >= 0; x--) {
			if (boardService.isOccupiedAt(x, piece.y)) {
				moves.add(new Move(piece.getLocation(), new Point(x, piece.y)));
				break;
			}
				
			moves.add(new Move(piece.getLocation(), new Point(x, piece.y)));
		}

		Move[] posibleMoves = moves.stream().toArray(Move[]::new);
	
		piece.setMoves(posibleMoves);

		return posibleMoves;
	}

	private void knightMoves() {

		Move topLeft = new Move(piece.getLocation(), new Point(piece.x - 2, piece.y - 1));
		Move topRight = new Move(piece.getLocation(), new Point(piece.x - 2, piece.y + 1));

		Move bottomLeft = new Move(piece.getLocation(), new Point(piece.x + 2, piece.y - 1));
		Move bottomRight = new Move(piece.getLocation(), new Point(piece.x + 2, piece.y + 1));

		Move leftTop = new Move(piece.getLocation(), new Point(piece.x - 1, piece.y - 2));
		Move leftBottom = new Move(piece.getLocation(), new Point(piece.x + 1, piece.y - 2));

		Move rightTop = new Move(piece.getLocation(), new Point(piece.x - 1, piece.y + 2));
		Move rightBottom = new Move(piece.getLocation(), new Point(piece.x + 1, piece.y + 2));

		piece.setMoves(
				new Move[] { topLeft, topRight, bottomLeft, bottomRight, leftTop, leftBottom, rightTop, rightBottom });
	}

	private Move[] bishopMoves() {

		List<Move> posibleMoves = new ArrayList<Move>();

		// from piece.x-1 to 0 - V cross shape
		boolean isLeftStuck = false;
		boolean isRightStuck = false;
		for (int i = piece.x - 1, spacingY = 1; i >= 0; i--, spacingY++) {
			
			// at the point is stuck by another color!
			if (boardService.isOccupiedAt(i, piece.y + spacingY)) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y + spacingY)));
				isRightStuck = true;
			}
			if (boardService.isOccupiedAt(i, piece.y - spacingY)) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y - spacingY)));
				isLeftStuck = true;
			}
			if (isLeftStuck && isRightStuck)
				break; // both two way is stuck

			if (!isLeftStuck) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y - spacingY)));
			}
			if (!isRightStuck) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y + spacingY)));
			}
		}

		// from piece.x+1 to 7 - ^ cross shape
		isLeftStuck = false;
		isRightStuck = false;
		for (int i = piece.x + 1, spacingY = 1; i <= 7; i++, spacingY++) {

			if (boardService.isOccupiedAt(i, piece.y + spacingY)) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y + spacingY)));
				isRightStuck = true;
			}
			if (boardService.isOccupiedAt(i, piece.y - spacingY)) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y - spacingY)));
				isLeftStuck = true;
			}
			if (isLeftStuck && isRightStuck)
				break; // both two way is stuck

			if (!isLeftStuck) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y - spacingY)));
			}
			if (!isRightStuck) {
				posibleMoves.add(new Move(piece.getLocation(), new Point(i, piece.y + spacingY)));
			}
		}

		Move[] moves = posibleMoves.stream().toArray(Move[]::new);

		piece.setMoves(moves);

		return moves;
	}

	private void queenMoves() {

		Move[] bishopMoves = bishopMoves();

		Move[] rookMoves = rookMoves();
		
		Move[] moves = Stream.of(bishopMoves, rookMoves).flatMap(Stream::of).toArray(Move[]::new);
		piece.setMoves(moves);
	}

	private void kingMoves() {

		List<Move> moves = Arrays.asList(
				new Move(piece.getLocation(), new Point(piece.x    , piece.y + 1)), // right
				new Move(piece.getLocation(), new Point(piece.x    , piece.y - 1)), // left
				new Move(piece.getLocation(), new Point(piece.x - 1, piece.y)), // top
				new Move(piece.getLocation(), new Point(piece.x + 1, piece.y)), // bottom
				new Move(piece.getLocation(), new Point(piece.x - 1, piece.y + 1)), // top - right
				new Move(piece.getLocation(), new Point(piece.x - 1, piece.y - 1)), // top - left
				new Move(piece.getLocation(), new Point(piece.x + 1, piece.y + 1)), // bottom - right
				new Move(piece.getLocation(), new Point(piece.x + 1, piece.y - 1)) // bottom - left				
		);
		
		piece.setMoves(moves.stream().toArray(Move[]::new));
	}

	@Override
	public void check() {

	}

}
