package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Bishop extends Piece {
	
	public Bishop(int x, int y, Color color) {
		super(x, y, PieceType.BISHOP, color);
		this.value = 3;
	}
	
	public Bishop() {
		
	}
		
//	@Override
//	public Point[] canMovesStraight() {
//		// TODO Auto-generated method stub
//		return new Point[] { };
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
//		// TODO Auto-generated method stub
//		return new Point[] { };
//	}

}
