package chess.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

import chess.piece.Piece;
import chess.utils.NotifyType;


public abstract class Drawable {
	
	private static final Stroke stroke = new BasicStroke(2);
	private static final Color HOVERED_COLOR = Color.CYAN;
	private static final Color CLICKED_COLOR = Color.ORANGE;
	
	private int hoverX, hoverY;
	private int clickedX = -1, clickedY = -1;

	private BoardGameUI boardGameUI;
	
	public Drawable(BoardGameUI boardGameUI) {
		this.boardGameUI = boardGameUI;
	}
	
	public void drawClickedBorder(Graphics2D g2) {
		
		if (clickedX == -1 && clickedY == -1) return;
		
		g2.setStroke(stroke);
		this.drawRect(g2, clickedX, clickedY, CLICKED_COLOR);
	}
	
	public void drawHoveredBorder(Graphics2D g2) {
		
		g2.setStroke(stroke);
		this.drawRect(g2, hoverX, hoverY, HOVERED_COLOR);
	}
	
	public void setHoverLocation(Point hoverLocation) {
		this.hoverY = hoverLocation.x;
		this.hoverX = hoverLocation.y;
		
		// notify board game ui
		this.boardGameUI.repaint();
	}

	public void setClickedLocation(Point clickedLocation) {
		this.clickedY = clickedLocation.x;
		this.clickedX = clickedLocation.y;
		
		this.boardGameUI.notify(NotifyType.SEND, new Point(clickedX, clickedY));
		this.boardGameUI.repaint();
	}
	
	public void drawRect(Graphics g, int x, int y, Color color) {
		
		g.setColor(color);
		g.drawRect(y * BoardGameUI.SQUARE_LENGTH + y, x * BoardGameUI.SQUARE_LENGTH + x, 
									BoardGameUI.SQUARE_LENGTH, BoardGameUI.SQUARE_LENGTH);
	}
	public void fillRect(Graphics g, int x, int y, Color color) {
		
		g.setColor(color);
		g.fillRect(y * BoardGameUI.SQUARE_LENGTH + y, x * BoardGameUI.SQUARE_LENGTH + x, 
				BoardGameUI.SQUARE_LENGTH, BoardGameUI.SQUARE_LENGTH);
	}
	
	abstract void draw(Graphics g, Piece piece);
}
