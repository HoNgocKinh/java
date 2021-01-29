package chess.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import chess.factoty.ChessPieceFactory;
import chess.pieces.Piece;
import chess.utils.Color;
import chess.utils.Move;
import chess.utils.PieceType;

public class BoardService {

    private Piece[][] board = new Piece[8][8];
    
    List<Move> opponentMoves;
    
    private static final BoardService INSTANCE = new BoardService();
    
    BoardServiceHelper helper = new BoardServiceHelper();
    
    private BoardService() {

        initBoardGame();
        

    }

    public static BoardService getInstance() {
    	return INSTANCE;
    }
    
    private void initBoardGame() {

    	helper.initBoardGame(board);
    }
    
    //sort value from highest to lowest
    public void initMoves() {
    	Arrays.stream(board).flatMap(x -> Arrays.stream(x)).forEach(Piece::initMoves);
    }
    
    public Piece[][] getBoard() {
        return this.board;
    }
    
    public Piece getPiece(int i, int j) {
    	Piece piece = board[i][j];   
    	return piece;
    }

    public PieceType getChessPiece(int i, int j) {
    	return board[i][j].getPieceType();
    	
    }
    public Color getColor(Point location) {
    	return board[location.x][location.y].getColor();
    }
    public boolean isOccupiedAt(int i, int j) {
    	if (i > 7 || i < 0 || j > 7 || j < 0) return false;
    	return board[i][j].getPieceType() != PieceType.EMPTY;
    }
    
    public void makeMove(Piece[][] board, Point from, Point to) {
    	
    	// swap two guys =]]]z
    	Piece piece = board[to.x][to.y];
    	board[to.x][to.y] = board[from.x][from.y];
    	board[from.x][from.y] = piece;    	
    }
          
    public List<Move> getValidMoves(List<Move> posibleMoves, Color color) {
    	
    	List<Piece> pieces = Arrays.stream(board).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    	
    	Piece king = getPiece(pieces, PieceType.KING, color);
    	
    	Piece[][] boardCopy;
    	List<Move> safeMoves = new ArrayList<Move>();
    	Point kingPosition;
    	
    	for (Move move: posibleMoves) {
    		
    		kingPosition = move.getFrom().equals(king.getLocation()) ? move.getTo() : king.getLocation();
    		    		
    		boardCopy = makeCopyOfBoard(board);
    		Move isSafeMove = makeEachMove(boardCopy, move, kingPosition, color);
    		if (isSafeMove != null) {
    			safeMoves.add(isSafeMove);
    		}
    	} 
    	
    	return safeMoves;
    }
    
    public List<Move> getMoves(Color color) {
    	  	 
    	List<Piece> pieces = Arrays.stream(board).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    	
    	List<Move> moves = helper.getMovesOfColor(board, pieces, color);
    	
    	return getValidMoves(moves, color);
    }
    
    public Move makeEachMove(Piece[][] boardCopy, Move move, Point kingPosition, Color color) {
    	
    	makeMove(boardCopy, move.getFrom(), move.getTo());
    	
    	List<Piece> pieces = Arrays.stream(boardCopy).flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
    	System.out.println(Color.changeColor(color));
    	List<Move> opponentMoves = helper.getMovesOfColor(boardCopy, pieces, Color.changeColor(color));
    	
    	Predicate<Move> kingDieInNextMove = opponentMove -> {
    		return opponentMove.getTo().equals(kingPosition);
    	};
    	
    	long isKingWillDie  = opponentMoves.stream().filter(kingDieInNextMove).count(); //if count > 0 meaning exist one piece will kill the AI king
    	
    	if (isKingWillDie == 0) { //defeat enemy or move king another position!
    		return move;
    	}
    	return null;
    }
    
    public Piece[][] makeCopyOfBoard(Piece[][] board) {
    	Piece[][] boardCopy = new Piece[8][8];
    	for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, boardCopy[i], 0, board[i].length);
        }
    	return boardCopy;
    }
    
    public boolean isKingCheck(List<Move> opponentMoves, Piece king) {
    	
    	return opponentMoves.stream().anyMatch(move -> move.getTo().equals(king.getLocation()));
    }
    public Piece getPiece(List<Piece> pieces, PieceType pieceType, Color color) {
    	    	
    	Predicate<Piece> sameTypeAndColor = piece -> {
    		return piece.getPieceType() != PieceType.EMPTY && piece.getPieceType() == pieceType && color == piece.getColor();
    	};

    	Piece piece = pieces.stream().filter(sameTypeAndColor)
    								 .findFirst()
    								 .get();

    	return piece;
    }
    
    public void testEachPiece() {
    	for (int i = 0; i < 8 ; i++) {
    		for (int j = 0; j < 8 ; j++) {
    			board[i][j] = ChessPieceFactory.getPiece(PieceType.EMPTY, i, j, Color.NONE);
    		}
    	}
    	         	

    	
//    	PAWN
//    	board[1][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 1, 2, Color.BLACK);
//    	board[3][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 3, 2, Color.WHITE);
//    	board[2][1] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 1, Color.WHITE);
//    	board[2][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 3, Color.WHITE);
    	
//    	KNIGHT
    	
//    	ROOK
//    	board[7][7] = ChessPieceFactory.getPiece(PieceType.ROOK, 7, 7, Color.BLACK);   	
//    	board[7][4] = ChessPieceFactory.getPiece(PieceType.KING, 7, 4, Color.BLACK);   	
    	
//    	board[3][2] = ChessPieceFactory.getPiece(PieceType.ROOK, 3, 2, Color.BLACK);
//    	board[2][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 2, Color.WHITE);
//    	board[4][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 2, Color.WHITE);
//    	board[3][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 3, 3, Color.WHITE);
//    	board[3][1] = ChessPieceFactory.getPiece(PieceType.PAWN, 3, 1, Color.WHITE);
    	
//    	BISHOP
//    	board[3][3] = ChessPieceFactory.getPiece(PieceType.BISHOP, 3, 3, Color.BLACK); 
//    	board[6][6] = ChessPieceFactory.getPiece(PieceType.PAWN, 6, 6, Color.WHITE); 
    	
//    	QUEEN
//    	board[3][2] = ChessPieceFactory.getPiece(PieceType.QUEEN, 3, 2, Color.BLACK);
//    	
//    	board[2][1] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 1, Color.WHITE);
//    	board[2][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 2, Color.WHITE);
//    	board[2][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 3, Color.WHITE);
//    	board[3][1] = ChessPieceFactory.getPiece(PieceType.PAWN, 3, 1, Color.WHITE);
//    	board[3][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 3, 3, Color.WHITE);
//    	board[4][1] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 1, Color.WHITE);
//    	board[4][2] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 2, Color.WHITE);
//    	board[4][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 3, Color.WHITE);
    	
//    	KING
      board[7][4] = ChessPieceFactory.getPiece(PieceType.KING, 7, 4, Color.WHITE);
//      board[7][0] = ChessPieceFactory.getPiece(PieceType.ROOK, 7, 0, Color.WHITE);
      board[7][7] = ChessPieceFactory.getPiece(PieceType.ROOK, 7, 7, Color.BLACK);
    	
    	//case Done!
//    	board[3][5] = ChessPieceFactory.getPiece(PieceType.KING, 3, 5, Color.WHITE);
//       
//    	board[2][4] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 4, Color.WHITE);
//    	board[2][6] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 6, Color.WHITE);
//    	board[4][4] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 4, Color.WHITE);
//    	board[4][6] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 6, Color.WHITE);
    }
    
    public void testMove() {
    	
    	board[1][2] = ChessPieceFactory.getPiece(PieceType.KNIGHT, 1, 2, Color.WHITE);
    	board[0][5] = ChessPieceFactory.getPiece(PieceType.EMPTY, 0, 5, Color.NONE);
    	board[1][6] = ChessPieceFactory.getPiece(PieceType.EMPTY, 1, 6, Color.NONE);
    	board[1][7] = ChessPieceFactory.getPiece(PieceType.EMPTY, 1, 7, Color.NONE);
    	board[2][6] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 6, Color.BLACK);
    	board[2][7] = ChessPieceFactory.getPiece(PieceType.BISHOP, 2, 7, Color.BLACK);
    	board[3][7] = ChessPieceFactory.getPiece(PieceType.PAWN, 2, 7, Color.BLACK);
    	
    	board[4][3] = ChessPieceFactory.getPiece(PieceType.PAWN, 4, 3, Color.WHITE);
    	board[4][5] = ChessPieceFactory.getPiece(PieceType.QUEEN, 4, 5, Color.WHITE);
    	board[6][3] = ChessPieceFactory.getPiece(PieceType.EMPTY, 6, 3, Color.NONE);
    	board[7][1] = ChessPieceFactory.getPiece(PieceType.EMPTY, 7, 1, Color.NONE);
    	board[7][3] = ChessPieceFactory.getPiece(PieceType.EMPTY, 7, 3, Color.NONE);
    }
    
    public void showChessBoard() {

        for (Piece[] row : board) {
            for (Piece piece : row) {
            	if (piece.getPieceType() != PieceType.EMPTY) {
            		System.out.print(piece.getColor() + " " + piece.getPieceType() + "\t");
            	}
            		
            	else 
            		System.out.print("." + "\t\t");
            }
            System.out.println();
        }
    }

    public void print(Move[] points) {

        for (Move point : points) {
            System.out.println(point);
        }
    }
    //---------------------------------
    private Point hovered;
    
    public void setHoveredPoint(Point hovered) {
    	
    	
    	this.hovered = hovered;
    }
    public Point getHoveredPoint() {
    	return this.hovered;
    }  
    
    
}
