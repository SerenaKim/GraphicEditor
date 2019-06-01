package SubFrame;

import SubPanel.ColorPanel;

import javax.swing.*;
import java.awt.*;

public class RightUpInternalFrame extends JInternalFrame {

	public RightUpInternalFrame() {
		super("Color Choose", true, false, false, true);
		setSize(300, 350);
		setBackground(Color.WHITE);

		ColorPanel colorPanel = new ColorPanel();
		this.add(colorPanel);

		setVisible(true);
	}

}
