package SubFrame;

import Information.FigureBuffer;
import Information.Information;
import SubPanel.DrawPanel;
import figure.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class DrawInternalFrame extends JInternalFrame {

	public DrawPanel draw;
	private String mName;

	public DrawInternalFrame(String name) {
		super(name, true, true, true, true);

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C) {
					// Copy Current Figure
					if (Information.getCurrentFigure() != null) {
						FigureBuffer.getInstance().replaceBuffer(Information.getCurrentFigure());

					} else {
						JOptionPane.showMessageDialog(null, "Error : I can't find Figure", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
					// Paste Bufferd FigureSet
					if (!FigureBuffer.getInstance().isEmpty()) {
						if (Information.getCurrentJPanel() != null) {
							Information.getCurrentJPanel()
									.addVector((Vector<Figure>) FigureBuffer.getInstance().getBuffer().clone());
							FigureBuffer.getInstance().clearBuffer();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Error : I can't find BufferSet", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		this.setFocusable(true);
		this.mName = name;
		setSize(500, 500);
		setBackground(Color.WHITE);

		draw = new DrawPanel();
		add(draw);
		setVisible(true);
	}

	public void replacePanel(DrawPanel panel) {
		draw.changeVector(panel.getVector());
		repaint();
	}
}
