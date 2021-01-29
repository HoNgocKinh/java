package chess.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chess.piece.Piece;
import chess.piece.PieceAbstractFactory;
import chess.piece.PieceConstants;
import chess.piece.black.BlackPieceFactory;
import chess.piece.white.WhitePieceFactory;
import chess.ui.GameUI;
import chess.utils.ColorType;
import chess.utils.NotifyType;
import chess.utils.PieceType;
import chess.utils.helper.BoardHelper;
import chess.utils.observer.Notifable;

public class BoardGame implements Notifable {
	
	private List<Piece> board = new ArrayList<Piece>();
	private BoardHelper boardHelper;
	
	private BoardGame() {
		
	}
	
	public void setUp() {
		
		initBoardGame();
		initBoardGameUI();
	}
	private void initBoardGame() {
		
		Map<ColorType, PieceAbstractFactory> factory = new HashMap<ColorType, PieceAbstractFactory>();
		factory.put(ColorType.BLACK, new BlackPieceFactory());
		factory.put(ColorType.NONE, new BlackPieceFactory());
		factory.put(ColorType.WHITE, new WhitePieceFactory());
		
		for (int i = 0; i < PieceConstants.WIDTH; i++) {
			for (int j = 0; j < PieceConstants.HEIGHT; j++) {
				
				ColorType color = ColorType.colorAt(i);
				PieceType type = PieceType.getPieceType(i, j);
				
				PieceAbstractFactory pieceFactory = factory.get(color);
				board.add(pieceFactory.getPiece(i, j, type));
			}
		}
		boardHelper = new BoardHelper(board);
	}
	
	public void initBoardGameUI() {
		
		GameUI ui = new GameUI();
		ui.draw(board);
	}
	
	private static BoardGame INSTANCE = new BoardGame();
	public static BoardGame getInstance() {
		return INSTANCE;
	}
	@Override
	public Object notify(NotifyType type, Object obj) {
		
		if (type == NotifyType.RECEIVE) {
//			Point pieceClickedLocation = (Point) obj;
//			Optional<Piece> pieceWrapper = boardHelper.findPieceAtLocation(pieceClickedLocation);
//			if (pieceWrapper.isPresent()) {
//				Piece piece = pieceWrapper.get();
//				
//				List<Point> moves = piece.getMoves();
//				System.out.println(moves);
//				// notify for boardGame to draw valid Moves
//				new Subject<Notifable>(BoardGameUI.getInstance()).notify(moves);
//			}
		}
		return null;
	}
}
