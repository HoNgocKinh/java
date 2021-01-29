package chess.utils.helper;

import java.awt.Point;

import chess.ui.BoardGameUI;

public class PointHelper {
	
	public static Point extract2RowAndCol(Point point) {
		
		double x = point.getX();
		double y = point.getY();
		
		int row = 0;
		int col = 0;
		
		if (x > (BoardGameUI.MAX_SQUARE - 1) * BoardGameUI.SQUARE_LENGTH) {
			row = BoardGameUI.MAX_SQUARE - 1;
		}
		if (y > (BoardGameUI.MAX_SQUARE - 1) * BoardGameUI.SQUARE_LENGTH) {
			col = BoardGameUI.MAX_SQUARE - 1;
		}
		
		if (row != 0 && col != 0) {
			return new Point(row, col);
		}
		
		for (int i = 0; i < BoardGameUI.MAX_SQUARE; i++) {
			if (i * BoardGameUI.SQUARE_LENGTH <= x && (i + 1) * BoardGameUI.SQUARE_LENGTH >= x) {
				row = i;
			}
			if (i * BoardGameUI.SQUARE_LENGTH <= y && (i + 1) * BoardGameUI.SQUARE_LENGTH >= y) {
				col = i;
			}
 		}
 		return new Point(row, col);
	}
}
