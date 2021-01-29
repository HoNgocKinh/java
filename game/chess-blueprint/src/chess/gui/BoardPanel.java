package chess.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import chess.board.BoardService;

public class BoardPanel extends JPanel implements Runnable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final int WIDTH_SQUARE = 70;
    public static final int HEIGHT_SQUARE = 70;
    public static final int BOARD_WIDTH = 8;
    public static final int BOARD_HEIGHT = 8;
    public static final int BOUND_X = Game.WIDTH/4 + 100;
    public static final int BOUND_Y = 5;
    
    private BoardService boardService = BoardService.getInstance();

    private Point[] validMoves;

    public BoardPanel() {
        initAttributes();
    }

    void initAttributes() {
        this.setBounds(BOUND_X, BOUND_Y, 581, 581);        

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoardGame(g);
        drawHoveredPiece(g, boardService.getHoveredPoint());
        drawValidMove(g, validMoves);
    }

    private void drawBoardGame(Graphics g) {

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {

                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(177, 175, 169));
                } else {
                    g.setColor(new Color(124, 127, 144));
                }
                g.fillRect(j * HEIGHT_SQUARE + 3 * j, i * WIDTH_SQUARE + 3 * i, WIDTH_SQUARE, HEIGHT_SQUARE);

                g.setColor(Color.red);
                g.drawString(boardService.getChessPiece(i, j).toString(), j * HEIGHT_SQUARE + j + 20, i * WIDTH_SQUARE + i + 40);
            }
        }
    }

    private void drawHoveredPiece(Graphics g, Point hovered) {
        if (hovered != null) {

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g.setColor(Color.blue);
            g.fillRect(hovered.y * HEIGHT_SQUARE + 3 * hovered.y, hovered.x * WIDTH_SQUARE + 3 * hovered.x,
                    WIDTH_SQUARE, HEIGHT_SQUARE);
        }
    }

    private void drawValidMove(Graphics g, Point[] validMoves) {

        if (validMoves != null) {
            for (Point point : validMoves) {
                g.setColor(Color.green);
                g.fillRect(point.y * HEIGHT_SQUARE + 3 * point.y, point.x * WIDTH_SQUARE + 3 * point.x,
                        WIDTH_SQUARE, HEIGHT_SQUARE);
            }
        }
    }

    public void run() {

    	while (true) {
    		
    		try {
                repaint();
                revalidate();
                Thread.sleep(200);
            }catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }

       
    public BoardService getBoardService() {
    	return this.boardService;
    }
}
