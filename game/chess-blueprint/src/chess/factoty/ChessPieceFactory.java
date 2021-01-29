package chess.factoty;

import java.util.HashMap;
import java.util.Map;

import chess.pieces.*;
import chess.utils.Color;
import chess.utils.PieceType;

public class ChessPieceFactory {

    private static Map<PieceType, Piece> map = new HashMap<PieceType, Piece>();

    public static Piece getPiece(PieceType piece, int x, int y, Color color) {

        switch (piece) {
            case PAWN: {
                if (map.get(piece) == null) {
                    map.put(piece, new Pawn(x, y, color).initMoves());
                }
            }
            case ROOK: {
                if (map.get(piece) == null) {
                    map.put(piece, new Rook(x, y, color));
                }
            }
            case KNIGHT: {
                if (map.get(piece) == null) {
                    map.put(piece, new Knight(x, y, color));
                }
            }
            case BISHOP: {
                if (map.get(piece) == null) {
                    map.put(piece, new Bishop(x, y, color));
                }
            }
            case QUEEN: {
                if (map.get(piece) == null) {
                    map.put(piece, new Queen(x, y, color));
                }
            }
            case KING: {
                if (map.get(piece) == null) {
                    map.put(piece, new King(x, y, color));
                }
            }
            case EMPTY: {
            	if (map.get(piece) == null) {
                    map.put(piece, new Empty(x, y, color));
                }
            }
            default:
                break;
        }
        return map.get(piece) != null ? map.get(piece).clone(x, y, color) : null;
    }

}
