package chess.ui.events;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import chess.ui.Drawable;
import chess.utils.helper.PointHelper;

public class MouseMoveEventHandler implements MouseMotionListener {

	private Drawable drawable;
	
	public MouseMoveEventHandler(Drawable drawable) {
		this.drawable = drawable;
	}
	
	@Override
	public void mouseDragged(MouseEvent evt) { }

	@Override
	public void mouseMoved(MouseEvent evt) {
		
		Point colAndRow = PointHelper.extract2RowAndCol(evt.getPoint());
		this.drawable.setHoverLocation(colAndRow);
	}
}
