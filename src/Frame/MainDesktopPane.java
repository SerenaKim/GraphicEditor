package Frame;

import SubFrame.DrawInternalFrame;
import SubFrame.RightDownInternalFrame;
import SubFrame.RightUpInternalFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class MainDesktopPane extends JDesktopPane {

	private static MainDesktopPane instance;
	private HashMap<String, DrawInternalFrame> drawInternalFrameSet;
	private RightUpInternalFrame rightUpInternalFrame;
	private RightDownInternalFrame rightDownInternalFrame;
	private int previousWidth = -1;

	public MainDesktopPane() {

		drawInternalFrameSet = new HashMap<String, DrawInternalFrame>();

		this.setVisible(true);
		this.setBackground(Color.WHITE);
		this.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		rightUpInternalFrame = new RightUpInternalFrame();
		rightDownInternalFrame = RightDownInternalFrame.getInstance();

		rightUpInternalFrame.setLocation(1190, 0);
		rightDownInternalFrame.setLocation(1190, 360);

		//this.add(drawInternalFrame);
		this.add(rightUpInternalFrame);
		this.add(rightDownInternalFrame);

	}

	public static MainDesktopPane getInstance() {
		if (instance == null)
			instance = new MainDesktopPane();
		return instance;
	}

	@Override
	public void paintComponent(Graphics g) {
		int width = getWidth();

		if (width != previousWidth) {
			rightUpInternalFrame.setLocation(width - 300, 0);
			rightDownInternalFrame.setLocation(width - 300, 350);
		}
		previousWidth = width;
	}

	public void addDrawFrameToSet(String name, DrawInternalFrame newFrame) {
		drawInternalFrameSet.put(name, newFrame);
	}

	public DrawInternalFrame getDrawFrame(String key) throws IOException {
		drawInternalFrameSet.get(key).draw.setImagePath(key);
		return drawInternalFrameSet.get(key);
	}
}
