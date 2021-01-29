package chess.ui.events;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import chess.ui.Drawable;
import chess.utils.helper.PointHelper;

public class MouseClickEventHandler implements MouseListener {
	
	private Drawable drawable;
	
	public MouseClickEventHandler(Drawable drawable) {
		this.drawable = drawable;
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) {

		Point colAndRow = PointHelper.extract2RowAndCol(evt.getPoint());
		this.drawable.setClickedLocation(colAndRow);
	}

	@Override
	public void mouseEntered(MouseEvent evt) {}

	@Override
	public void mouseExited(MouseEvent evt) {}

	@Override
	public void mousePressed(MouseEvent evt) {}

	@Override
	public void mouseReleased(MouseEvent evt) {}
	
}
