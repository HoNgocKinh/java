package chess.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import chess.board.BoardService;
import chess.minimax.AIPlayer;
import chess.utils.Color;
import chess.utils.Move;
import chess.utils.PieceType;

public class Game extends JFrame implements MouseMotionListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 620;
	
//	private BoardService boardService;
	
	public Game() {
		
		initAttributes();
	}
	
	void initAttributes() {
				
		setTitle("Chess Game!");
		setLocation(100, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.addMouseMotionListener(this);
		
		setLayout(null);
		setResizable(false);
		setSize(WIDTH, HEIGHT);
	}
	
	public void load() {
		
		PlayerPanel pp = new PlayerPanel();
		BoardPanel bp = new BoardPanel();
		
//		this.boardService = bp.getBoardService();
		bp.addMouseMotionListener(this);
		bp.addMouseListener(this);
		
		this.add(pp);
		this.add(bp);
		
		setVisible(true);
	}
	

  
//  @Override
//  public void mousePressed(MouseEvent evt) {
      // TODO Auto-generated method stub
//      int x = evt.getX();
//      int y = evt.getY();
//
//      int i = (y - (3 * y / WIDTH_SQUARE)) / WIDTH_SQUARE;
//      int j = (x - (3 * x / HEIGHT_SQUARE)) / HEIGHT_SQUARE;
//
//      
//      
//      this.validMoves = boardService.getValidMovesAt(i, j);
//      
//      
//
//		if (this.board[i][j] != ChessPiece.EMPTY) {
//						
//			clickedPiece = boardService.getPieceAt(i, j);
//			this.validMoves = clickedPiece.getPosibleMoves();	
//		}		
//  }
	
	public static void main(String[] args) {
		
//		Game game = new Game();
//		game.load();		

		BoardService boardService = BoardService.getInstance();
//		boardService.testMove();
//		boardService.testEachPiece();
		//boardService.initBoardGame();
		boardService.initMoves();
		
		boardService.print(boardService.getPiece(7, 4).getMoves());
//		PAWN
//		boardService.print(boardService.getPiece(1, 2).getMoves());
		
//		ROOK
//		boardService.print(boardService.getPiece(7, 7).getMoves());
		
//		BISHOP
//		boardService.print(boardService.getPiece(3, 3).getMoves());
		
//		QUEEN
//		boardService.print(boardService.getPiece(3, 2).getMoves());
		
		
//		KING 

		
//		boardService.showChessBoard();
	
//		AIPlayer ai = new AIPlayer();
//		ai.getNextMoves(Color.BLACK);
		

//		boardService.showChessBoard();
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		// TODO Auto-generated method stub
		
//
//	     this.hovered = new Point(i, j);
		
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		// TODO Auto-generated method stub
		int x = evt.getX();
		int y = evt.getY();		
		
		int i = (y - (3 * y / BoardPanel.WIDTH_SQUARE)) / BoardPanel.WIDTH_SQUARE;
		int j = (x - (3 * x / BoardPanel.HEIGHT_SQUARE)) / BoardPanel.HEIGHT_SQUARE;
		
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		
//		System.out.println("i = " + i + " j = " + j);
//		this.boardService.setHoveredPoint( new Point(i, j));
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		
//		int x = evt.getX();
//		int y = evt.getY();		
		
//		int i = (y - (3 * y / BoardPanel.WIDTH_SQUARE)) / BoardPanel.WIDTH_SQUARE;
//		int j = (x - (3 * x / BoardPanel.HEIGHT_SQUARE)) / BoardPanel.HEIGHT_SQUARE;
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
