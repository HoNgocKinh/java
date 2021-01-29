package chess.utils;

public enum ColorType {
	NONE, WHITE, BLACK;
	
	public ColorType getOppositeColor(ColorType color) {
		
		if (color == ColorType.WHITE) {
			return ColorType.BLACK;
		}
		return ColorType.WHITE;
	}
	
	public static ColorType colorAt(int i) {
		switch (i) {
			case 6: case 7:
				return ColorType.WHITE;
			case 0: case 1:
				return ColorType.BLACK;
			default: 
				return ColorType.NONE;
		}
	}
}
