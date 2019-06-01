package Frame;

import Information.Information;
import SubFrame.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private static MainFrame instance;
	private LeftPanel leftPanel;
	private BottomLabel bottomLabel;
	private TopPanel topPanel;
	private TopMenu menuBar;

	public MainFrame(String name) {

		super(name);
		leftPanel = new LeftPanel();
		bottomLabel = new BottomLabel("Start");
		topPanel = new TopPanel();

		this.add(leftPanel, BorderLayout.WEST);
		this.add(bottomLabel, BorderLayout.SOUTH);
		this.add(topPanel, BorderLayout.NORTH);
		menuBar = new TopMenu();
		this.setJMenuBar(menuBar);
		this.add(MainDesktopPane.getInstance());
	}

	public static MainFrame getInstance() {
		if (instance == null)
			instance = new MainFrame(Information.PROGRAM_NAME);
		return instance;
	}

	public void addDrawFrame(String name) {
		DrawInternalFrame newFrame = new DrawInternalFrame(name);
		newFrame.setSize(500, 500);
		MainDesktopPane.getInstance().addDrawFrameToSet(name, newFrame);
		MainDesktopPane.getInstance().add(newFrame);
	}

	public void setBottomLabel(String text) {
		Color color = Information.getCurrentColor();
		String mode = Information.getCurrentModeToString();
		bottomLabel.setText("Current mode : " + mode + "  Current coordinates : " + text + "    R : " + color.getRed() + " G : "
				+ color.getGreen() + " B : " + color.getBlue());
	}

	public void setBottomLabel(Color color) {
		String mode = Information.getCurrentModeToString();
		bottomLabel.setText("Current mode : " + mode + "   Current coordinates : Out of frame" + "    R : " + color.getRed() + " G : "
				+ color.getGreen() + " B : " + color.getBlue());
	}

	public void callColorFrame() {
		GetSpecifcColorInternalFrame getSpecifcColorInternalFrame = new GetSpecifcColorInternalFrame();
		MainDesktopPane.getInstance().add(getSpecifcColorInternalFrame);
	}

}
