package chess.pieces;

import java.awt.Point;

import chess.action.Actionable;
import chess.action.Movation;
import chess.action.ValidCheck;
import chess.utils.Color;
import chess.utils.Move;
import chess.utils.PieceType;

public abstract class Piece implements Cloneable {

    public int x;
    public int y;
    protected Color color;
    protected Move[] moves;
    protected int value = 0;
    
	boolean clicked = false;
    protected Actionable action;
    private PieceType pieceType;
    
	public Piece(int x, int y, PieceType pieceType, Color color) {
        this.x = x;
        this.y = y;
        this.pieceType = pieceType;
        this.color = color;  
        
    }
	
    public Piece() {

    }
     
    public Piece initMoves() {
    	
    	setUpMoves();                               
    	validMoves();  
    	return this;
    }
    
    private final void setUpMoves() {
    	
    	action = new Movation(this);
    	action.move();
    }

    private final void validMoves() {
    	action = new ValidCheck(this);
    	action.check();
    }
    
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public Point getLocation() {
    	return new Point(x, y);
    }
    
    public Move[] getMoves() {
    	           	
        return this.moves;
    }
    public void setMoves(Move[] moves) {
    	this.moves = moves;
    }

    public Piece clone(int x, int y, Color color) {

        Piece piece = null;
        try {

            piece = (Piece) super.clone();
            
            piece.x = x;
            piece.y = y;
            piece.color = color;            
            
        } catch (CloneNotSupportedException ex) {

            System.out.println(ex.getMessage());
        }
        return piece;
    }
    
    public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType piece) {
		this.pieceType = piece;
	}
    
	public Color getColor() {
		return color;
	}
	public int getValue() {
		return value;
	}
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	if (moves != null) {
    		return "Piece: [x= " + x + " ,y= " + y + " , type= " + pieceType + " , Color= " + color + ", Moves: " + moves.length +"]";
    	}
    	return "Piece: [x= " + x + " ,y= " + y + " , type= " + pieceType + " , Color= " + color + "]";
    }
}
