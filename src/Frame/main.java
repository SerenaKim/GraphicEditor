package Frame;

import Information.Information;

import javax.swing.*;
import java.awt.*;

public class main {

	public static void main(String[] args) {

		MainFrame.getInstance().setBackground(Color.WHITE);
		MainFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getInstance().setSize(Information.PROGRAM_WIDTH, Information.PROGRAM_HEIGHT);
		MainFrame.getInstance().setVisible(true);

	}

}
