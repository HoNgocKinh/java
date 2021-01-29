package chess.utils;

import java.awt.Point;

public class Move {
	
	Point from;
	Point to;
	
	public Move(Point from, Point to) {
		this.from = from;
		this.to = to;
	}

	public Point getFrom() {
		return from;
	}

	public void setFrom(Point from) {
		this.from = from;
	}

	public Point getTo() {
		return to;
	}

	public void setTo(Point to) {
		this.to = to;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Move from: " + from + " -> to: " + to;
	}
}
