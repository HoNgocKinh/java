package chess.pieces;

import chess.utils.Color;
import chess.utils.PieceType;

public class Knight extends Piece {

	public Knight(int x, int y, Color color) {
		super(x, y, PieceType.KNIGHT, color);
		this.value = 3;
	}
	
	public Knight() {
		
	}
		
//	@Override
//	public Point[] canMovesStraight() {
//		// TODO Auto-generated method stub
//		
//		// we defined a special moves with out abtract method of parent!
//			
//		return knightMoves();
//	}
//	
//	private Point[] knightMoves() {
//		
//		Point topLeft = new Point(x - 2, y - 1);
//		Point topRight = new Point(x - 2, y + 1);
//		
//		Point bottomLeft = new Point(x + 2, y - 1);
//		Point bottomRight = new Point(x + 2, y + 1);
//		
//		Point leftTop = new Point(x - 1, y - 2);
//		Point leftBottom = new Point(x + 1, y - 2);
//		
//		Point rightTop = new Point(x - 1, y + 2);
//		Point rightBottom = new Point(x + 1, y + 2);
//		
//		return new Point[] {topLeft, topRight, bottomLeft, bottomRight, leftTop, leftBottom, rightTop, rightBottom };
//	}
//	
//	@Override
//	public Point[] canMovesCross() {
//		// TODO Auto-generated method stub
//		return new Point[] {};
//	}
//
//	@Override
//	public Point[] canMovesSide() {
//		// TODO Auto-generated method stub
//		return new Point[] {};
//	}

}
