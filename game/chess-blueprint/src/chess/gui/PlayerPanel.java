package chess.gui;

import java.awt.Color;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PlayerPanel() {
		
		initAttributes();
	}
	
	private void initAttributes() {
		this.setBounds(0, 0, Game.WIDTH/4, Game.HEIGHT );
		this.setBackground(Color.red);		
	}
}
