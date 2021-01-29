package chess.utils;

public enum Color {
	BLACK, WHITE, NONE;
	
	public static Color getColor(int i) {
		return Color.values()[i];
	}
	
	public static Color changeColor(Color color) {
		return Color.values()[1 - color.ordinal()];
	}
}
