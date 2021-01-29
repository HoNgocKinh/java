package chess.ui;

import java.awt.Color;
import java.awt.Graphics;

import chess.piece.Piece;
import chess.utils.PieceType;

public class DrawPieceByText extends Drawable {
	
	public DrawPieceByText(BoardGameUI boardGameUI) {
		super(boardGameUI);
	}
	@Override
	public void draw(Graphics g, Piece piece) {

		int row = piece.getX();
		int col = piece.getY();
		
		if (piece.getType() == PieceType.NONE) return;
		
		g.setColor(Color.BLACK);
		g.drawString(piece.getType().toString(), col * BoardGameUI.SQUARE_LENGTH + col + 10, row * BoardGameUI.SQUARE_LENGTH + row + BoardGameUI.SQUARE_LENGTH/2 + 7);
	}
}
