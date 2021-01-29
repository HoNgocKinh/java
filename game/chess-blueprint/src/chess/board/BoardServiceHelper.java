package chess.board;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import chess.factoty.ChessPieceFactory;
import chess.pieces.Piece;
import chess.utils.Color;
import chess.utils.Move;
import chess.utils.PieceType;

public class BoardServiceHelper {
	
	public void initBoardGame(Piece[][] board) {
		
        setRookPosition(board);
        setKnightPosition(board);
        setBishopPosition(board);
        setQueenPosition(board);
        setKingPosition(board);
        setPawnPosition(board);
        setEmptyPiece(board);
    }
	//Comparator ? 0 0 1 3 3 8 -> Person1, Person2 -> p1.age - p2.age

	private void setRookPosition(Piece[][] board) {

        board[0][0] = ChessPieceFactory.getPiece(PieceType.ROOK, 0, 0, Color.BLACK);
        board[0][7] = ChessPieceFactory.getPiece(PieceType.ROOK, 0, 7, Color.BLACK);
        board[7][0] = ChessPieceFactory.getPiece(PieceType.ROOK, 7, 0, Color.WHITE);
        board[7][7] = ChessPieceFactory.getPiece(PieceType.ROOK, 7, 7, Color.WHITE);
    }

	private void setKnightPosition(Piece[][] board) {
        board[0][1] = ChessPieceFactory.getPiece(PieceType.KNIGHT, 0, 1, Color.BLACK);
        board[0][6] = ChessPieceFactory.getPiece(PieceType.KNIGHT, 0, 6, Color.BLACK);
        board[7][1] = ChessPieceFactory.getPiece(PieceType.KNIGHT, 7, 1, Color.WHITE);
        board[7][6] = ChessPieceFactory.getPiece(PieceType.KNIGHT, 7, 6, Color.WHITE);
    }

    private void setBishopPosition(Piece[][] board) {
      
        board[0][2] = ChessPieceFactory.getPiece(PieceType.BISHOP, 0, 2, Color.BLACK);
        board[0][5] = ChessPieceFactory.getPiece(PieceType.BISHOP, 0, 5, Color.BLACK);
        board[7][2] = ChessPieceFactory.getPiece(PieceType.BISHOP, 7, 2, Color.WHITE);
        board[7][5] = ChessPieceFactory.getPiece(PieceType.BISHOP, 7, 5, Color.WHITE);
    }

    private void setQueenPosition(Piece[][] board) {
    	
        board[0][3] = ChessPieceFactory.getPiece(PieceType.QUEEN, 0, 3, Color.BLACK);
        board[7][3] = ChessPieceFactory.getPiece(PieceType.QUEEN, 7, 3, Color.WHITE);
    }

    private void setKingPosition(Piece[][] board) {
        //board[0][4] = ChessPieceFactory.getPiece(PieceType.KING, 0, 4, Color.BLACK);
        //board[7][4] = ChessPieceFactory.getPiece(PieceType.KING, 7, 4, Color.WHITE);

    }

    private void setPawnPosition(Piece[][] board) {
        for (int i = 0; i < 8; i++) {
            board[1][i] = ChessPieceFactory.getPiece(PieceType.PAWN, 1, i, Color.BLACK);
            board[6][i] = ChessPieceFactory.getPiece(PieceType.PAWN, 6, i, Color.WHITE);
        }
        
    }

    private void setEmptyPiece(Piece[][] board) {

        for (int i = 0; i < 8; i++) {
            board[2][i] = ChessPieceFactory.getPiece(PieceType.EMPTY, 2, i, Color.NONE);
            board[3][i] = ChessPieceFactory.getPiece(PieceType.EMPTY, 3, i, Color.NONE);
            board[4][i] = ChessPieceFactory.getPiece(PieceType.EMPTY, 4, i, Color.NONE);
            board[5][i] = ChessPieceFactory.getPiece(PieceType.EMPTY, 5, i, Color.NONE);
        }
    }
    
    public List<Move> getMovesOfColor(Piece[][] board, List<Piece> pieces, Color color) {
    	    	
    	Predicate<Piece> isBelongsOfColor = piece -> {
    		return piece.getColor() == color;
    	};
    	
    	// update moves of another color!
    	Arrays.stream(board).flatMap(x -> Arrays.stream(x))
    	.filter(isBelongsOfColor)
    	.sorted((Piece p1, Piece p2) -> p2.getValue() - p1.getValue())
    	.forEach(Piece::initMoves);
    	
    	
    	Predicate<Piece> canMovable = piece -> {
    		return piece.getMoves().length != 0;
    	};
    	
    	List<Move> moves = pieces.stream().filter(isBelongsOfColor.and(canMovable)) //filter
    				   .flatMap(piece -> Arrays.stream(piece.getMoves()))
    				   .collect(Collectors.toList());
    				       				   
    	return moves;
    }
}
