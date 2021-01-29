package chess.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

import chess.board.BoardGame;
import chess.piece.Piece;
import chess.ui.events.MouseClickEventHandler;
import chess.ui.events.MouseMoveEventHandler;
import chess.utils.EventType;
import chess.utils.NotifyType;
import chess.utils.observer.Notifable;
import chess.utils.observer.Subject;

public class BoardGameUI extends JPanel implements Notifable {
	
	private static final long serialVersionUID = 1L;
	public static final int SQUARE_LENGTH = 60;
	public static final int MAX_SQUARE = 8;
	private static BoardGameUI INSTANCE = null;
	
	private List<Point> moves = null;
	private Drawable drawable = null;
	private List<Piece> board = null;
	private Subject<BoardGame> pipe = new Subject<>(BoardGame.getInstance());
	
	public static BoardGameUI getInstance() {
		return INSTANCE;
	}
	
	public static BoardGameUI getInstance(List<Piece> board) {
		if (INSTANCE == null) {
			INSTANCE = new BoardGameUI(board);
		}
		
		return INSTANCE;
	}
	
	private BoardGameUI(List<Piece> board) {
		this.board = board;
		this.drawable = new DrawPieceByText(this);
		
		// attribute for panel
		this.setBounds(15, 7, GameUI.WIDTH, GameUI.HEIGHT);
		this.setOpaque(true);
		
		// settings event for panel
		MouseClickEventHandler mouseClickEvent = new MouseClickEventHandler(drawable);
		this.addMouseListener(mouseClickEvent);
		MouseMoveEventHandler mouseMoveEvent = new MouseMoveEventHandler(drawable);
		this.addMouseMotionListener(mouseMoveEvent);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard(g, this.board);
		drawClickedEvent(g);
		drawHoverEvent(g);
		drawValidMovesOfPiece(g, this.moves);
		drawPieces(g, this.board);
	}

	private void drawBoard(Graphics g, List<Piece> board) {
		
		for (Piece piece : board) {
			drawBackground(g, piece);	
		}
	}
	private void drawHoverEvent(Graphics g) {
		
		this.drawable.drawHoveredBorder((Graphics2D) g);
	}
	
	private void drawClickedEvent(Graphics g) {
		
		this.drawable.drawClickedBorder((Graphics2D) g);
	}
	private void drawValidMovesOfPiece(Graphics g, List<Point> moves) {
		
		g.setColor(Color.RED);
		if (moves == null) return;
		moves.stream().forEach(move -> {
			drawSquare(g, move.x, move.y);
		});
	}
	private void drawPieces(Graphics g, List<Piece> board) {
		for (Piece piece : board) {
			this.drawable.draw(g, piece);
		}
	}
	private void drawSquare(Graphics g, int x, int y) {
		
		g.fillRect(y * SQUARE_LENGTH + y, x * SQUARE_LENGTH  + x, SQUARE_LENGTH, SQUARE_LENGTH);
	}
	private void drawBackground(Graphics g, Piece piece) {

		int row = piece.getX();
		int col = piece.getY();
		
		if ((row + col) % 2 == 0) {
			g.setColor(Color.WHITE);
		}
		else {
			g.setColor(Color.LIGHT_GRAY);
		}
		this.drawable.fillRect(g, row, col, g.getColor());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Object notify(EventType type, Object obj) {
		
		// get notify from drawable
//		if (type == NotifyType.SEND) {
//			
//			return pipe.notify(NotifyType.RECEIVE, obj);
//		}
//		else {
//			this.moves = (List<Point>) obj;
//		}
		return null;
	}
}
