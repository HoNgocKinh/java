package chess.utils;

public enum PieceType {
	KING, QUEEN, BISHOP, KNIGHT, ROOK, PAWN, NONE;
	
	public static PieceType getPieceType(int i, int j) {
		
		switch (i) {
			case 0: case 7:
				switch (j) {
					case 0: case 7: 
						return PieceType.ROOK;
					case 1: case 6: 
						return PieceType.KNIGHT;
					case 2: case 5: 
						return PieceType.BISHOP;
					case 3: 
						return PieceType.QUEEN;
					default: 
						return PieceType.KING;
				}
			
			case 1: case 6:
				return PieceType.PAWN;
			
			default:
				return PieceType.NONE;
		}
	}
}
