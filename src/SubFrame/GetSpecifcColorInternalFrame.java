package SubFrame;

import Frame.MainFrame;
import Information.Information;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GetSpecifcColorInternalFrame extends JInternalFrame implements ChangeListener {

	JColorChooser colorChooser;

	public GetSpecifcColorInternalFrame() {
		super("GetSpecifcColorInternalFrame", true, true, true, true);
		setBackground(Color.DARK_GRAY);
		setSize(600, 400);
		setVisible(true);

		colorChooser = new JColorChooser(Information.getCurrentColor());
		colorChooser.getSelectionModel().addChangeListener(this);
		this.add(colorChooser);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Color newColor = colorChooser.getColor();
		Information.setCurrentColor(newColor.getRed(), newColor.getGreen(), newColor.getBlue(), newColor.getAlpha());
		MainFrame.getInstance().setBottomLabel(newColor);

	}

}
