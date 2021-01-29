package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Queen extends Piece {

	public Queen(int x, int y, Color color) {
		super(x, y, PieceType.QUEEN, color);
		this.value = 8;
	}
	
	public Queen() {
		
	}

//	@Override
//	public Point[] canMovesStraight() {
//		
//		Point[] moves = new Point[7]; // 7 moves from corner without current position
//		int index = 0;
//		for (int i = 0; i < 8; i++) {
//			if (i == x) continue; // at this Rook's position
//			moves[index++] = new Point(i, y);
//		}
//		return moves;
//	}
//
//	@Override
//	public Point[] canMovesCross() {
//		// TODO Auto-generated method stub
//
//		List<Point> moves = new ArrayList<Point>();
//		
//		// from x-1 to 0 - V cross shape
//		for (int i = x - 1, spacingY = 1; i >= 0; i--, spacingY++) {
//			moves.add(new Point(i, y + spacingY) );
//			moves.add(new Point(i, y - spacingY) );
//		}
//		
//		// from x+1 to 7 - ^ cross shape
//		for (int i = x + 1, spacingY = 1; i <= 7; i++, spacingY++) {
//			moves.add(new Point(i, y + spacingY) );
//			moves.add(new Point(i, y - spacingY) );
//		}
//		
//		
//		Point[] result = new Point[moves.size()];
//		result = moves.toArray(result);
//		
//		return result;
//	}
//
//	@Override
//	public Point[] canMovesSide() {
//		
//		// TODO Auto-generated method stub
//		Point[] moves = new Point[7]; // 7 moves from corner without current position
//		int index = 0;
//		for (int i = 0; i < 8; i++) {
//			if (i == y) continue; // at this Rook's position
//			moves[index++] = new Point(x, i);
//		}
//		return moves;
//	}

}
