package SubFrame;

import Frame.MainDesktopPane;
import Frame.MainFrame;
import Information.Information;
import figure.Figure;
import figure.Picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.Vector;

public class TopMenu extends JMenuBar {

	private JMenu fileMenu;
	private JMenuItem mkDrawPanel, fopen, fsave, open, save, exit;

	public BufferedImage createImage(JPanel panel) {

		int w = panel.getWidth();
		int h = panel.getHeight();
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		panel.paint(g);
		return bi;
	}

	public TopMenu() {
		this.setBackground(Color.WHITE);

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		mkDrawPanel = new JMenuItem("New DrawPanel");
		mkDrawPanel.setMnemonic('N');
		mkDrawPanel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int DrawFrameCnt = Information.getDrawFrame_Count();
				Information.addDrawFrame_Count();
				MainFrame.getInstance().addDrawFrame("" + DrawFrameCnt + "DrawPanel");

			}
		});

		fopen = new JMenuItem("Open With File");
		fopen.setMnemonic('R');
		fopen.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("DAT", "dat");
			fileChooser.setFileFilter(filter);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int judge = fileChooser.showOpenDialog(this);
			switch (judge) {
			case JFileChooser.APPROVE_OPTION:
				File x = fileChooser.getSelectedFile();
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream(x.getPath());
					ois = new ObjectInputStream(fis);
					Vector<Figure> vf = (Vector<Figure>) ois.readObject();
					Information.getCurrentJPanel().setStack(vf);
					Information.getCurrentJPanel().figureSet = vf;
					RightDownInternalFrame.getInstance().setListItems(vf);
					Information.getCurrentJPanel().paintComponent(Information.getCurrentJPanel().getGraphics());
					// Information.getCurrentJPanel().repaint();
					
				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					if (fis != null)
						try {
							fis.close();
						} catch (IOException ie) {
						}
					if (ois != null)
						try {
							ois.close();
						} catch (IOException ie) {
						}
				}
				break;

			case JFileChooser.CANCEL_OPTION:
				break;
			}
		});

		fsave = new JMenuItem("Save With File");
		fsave.setMnemonic('W');
		fsave.addActionListener(e -> {
			File x = null;
			JFileChooser jfilechooser = new JFileChooser();
			jfilechooser.setFileFilter(new FileNameExtensionFilter("DAT", "dat"));
			jfilechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int judge = jfilechooser.showSaveDialog(null);
			Vector<Figure> currentstack = Information.getCurrentJPanel().getStack().pop();
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			switch (judge) {
			case JFileChooser.APPROVE_OPTION:
				x = jfilechooser.getSelectedFile();
				if (jfilechooser.getFileFilter().getDescription().equals("DAT") && !x.getName().endsWith("dat")) {
					try {
						fos = new FileOutputStream(x.getPath() + ".DAT");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(currentstack);
						System.out.println("Saved");
					} catch (Exception ee) {
						ee.printStackTrace();
					} finally {
						if (fos != null)
							try {
								fos.close();
							} catch (IOException ie) {
							}
						if (oos != null)
							try {
								oos.close();
							} catch (IOException ie) {
							}
					}
				}
			case JFileChooser.CANCEL_OPTION:
				return;
			}

		});

		open = new JMenuItem("Open");
		open.setMnemonic('O');
		open.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();

			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "PNG", "jpg", "png");
			fileChooser.setFileFilter(filter);

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int judge = fileChooser.showOpenDialog(this);

			switch (judge) {
			case JFileChooser.APPROVE_OPTION:
				File x = fileChooser.getSelectedFile();
				try {
					BufferedImage image = ImageIO.read(x);

					MainFrame.getInstance().addDrawFrame(x.getPath());
					Picture picture = new Picture(0, 0, getWidth(), getHeight());
					picture.setGraphics(image);
					MainDesktopPane.getInstance().getDrawFrame(x.getPath()).draw.figureSet.addElement(picture);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;

			case JFileChooser.CANCEL_OPTION:
				break;
			}
		});

		save = new JMenuItem("Save");
		save.setMnemonic('S');
		save.addActionListener(e -> {
			File x = null;
			JFileChooser jfilechooser = new JFileChooser();

			jfilechooser.setFileFilter(new FileNameExtensionFilter("PNG", "png"));
			jfilechooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg"));

			jfilechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int judge = jfilechooser.showSaveDialog(null);
			ObjectOutputStream out = null;

			switch (judge) {
			case JFileChooser.APPROVE_OPTION:
				x = jfilechooser.getSelectedFile();
				if (jfilechooser.getFileFilter().getDescription().equals("JPG") && !x.getName().endsWith("jpg")) {
					x = new File(x.getPath() + ".JPG");
				}
				if (jfilechooser.getFileFilter().getDescription().equals("PNG") && !x.getName().endsWith("png")) {
					x = new File(x.getPath() + ".PNG");
				}
				System.out.println(jfilechooser.getFileFilter().getDescription());
				try {
					ImageIO.write(createImage(Information.getCurrentJPanel()),
							jfilechooser.getFileFilter().getDescription(), x);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case JFileChooser.CANCEL_OPTION:
				return;
			}

		});

		exit = new JMenuItem("Exit");
		exit.setMnemonic('E');
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		fileMenu.add(mkDrawPanel);
		fileMenu.add(fopen);
		fileMenu.add(fsave);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(exit);
		this.add(fileMenu);

	}

}
