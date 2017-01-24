package viewTUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Model.Board;
import Model.Disc;
import controller.Controller;

public class BoardPanel extends JPanel {
	private static final int ROWS = 6;
	private static final int COL = 7;
	private static final int W = 64;
	private static final int H = W;
	private static final Dimension PREF_SIZE = new Dimension(W, H);
	private Color black = new Color(30, 29, 28);
	private Color red = new Color(223, 23, 23);
	private Color white = new Color(252, 251, 250);

	private Board model;

	public BoardPanel(Board model, Controller controller) {
		this.model = model;
		initializeBoard();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanel panel = (JPanel) getComponentAt(e.getPoint());
				if (panel == null || panel == BoardPanel.this)
					return;
				int col = panel.getX() / W;
				for (int i = 0; i < ROWS; i++) {
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JPanel panel = (JPanel) getComponentAt(e.getPoint());
				if (panel == null || panel == BoardPanel.this)
					return;
				int col = panel.getX() / W;
				revalidate();
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		Disc.Color[][] board = model.getBoard();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COL; j++) {
				if (board[i][j] == Disc.Color.BLUE)
					this.getComponent((ROWS * COL - 1) - (i * 7) - (COL - 1 - j)).setBackground(black);
				else if (board[i][j] == Disc.Color.GREEN)
					this.getComponent((ROWS * COL - 1) - (i * 7) - (COL - 1 - j)).setBackground(red);
				else
					this.getComponent((ROWS * COL - 1) - (i * 7) - (COL - 1 - j)).setBackground(white);
			}
		}
	}

	private void initializeBoard() {
		setLayout(new GridLayout(ROWS, COL, 1, 1));
		setBackground(Color.black);
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COL; j++) {
				JPanel panel = new JPanel();
				panel.setPreferredSize(PREF_SIZE);
				add(panel);
			}
		}
	}
}