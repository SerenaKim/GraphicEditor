package SubFrame;

import Information.Information;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {

	private String[] pointSize = new String[100];
	private JComboBox textSizeList;

	private String[] LineSize = new String[20];
	private JComboBox LineSizeList;

	private String[] fontStyeSize = { "PLAIN", "BOLD", "ITALIC"};
	private int[] fontStyeSizeContant = { Font.PLAIN, Font.BOLD, Font.ITALIC};
	private JComboBox fontStyeList;

	public TopPanel() {

		FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
		this.setLayout(flow);

		add(new JLabel("   "));

		for (int i = 0; i < 100; i++) {
			pointSize[i] = "" + (i + 1);
		}
		textSizeList = new JComboBox<String>(pointSize);

		textSizeList.setEditable(false);
		textSizeList.setBackground(Color.WHITE);
		textSizeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int setSize = textSizeList.getSelectedIndex() + 1;
				Information.setTextSize(setSize);
			}
		});

		add(new JLabel("Text Size"));
		add(new JLabel("  "));
		add(textSizeList);

		add(new JLabel("             "));

		for (int i = 0; i < 20; i++) {
			LineSize[i] = "" + (i + 1);
		}
		LineSizeList = new JComboBox<String>(pointSize);
		LineSizeList.setEditable(false);
		LineSizeList.setBackground(Color.WHITE);
		LineSizeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int setSize = LineSizeList.getSelectedIndex() + 1;
				Information.setLineSize(setSize);
			}
		});
		add(new JLabel("Line Size"));
		add(new JLabel("  "));
		add(LineSizeList);

		add(new JLabel("             "));
		fontStyeList = new JComboBox<String>(fontStyeSize);
		fontStyeList.setEditable(false);
		fontStyeList.setBackground(Color.WHITE);
		fontStyeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int setFont = fontStyeSizeContant[fontStyeList.getSelectedIndex()];
				Information.setTextStyle(setFont);
			}
		});
		add(new JLabel("Font Style"));
		add(new JLabel("  "));
		add(fontStyeList);

		setBackground(Color.WHITE);
		setVisible(true);

	}

}
