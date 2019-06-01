package SubFrame;

import Information.Information;

import javax.swing.*;

import static SubPanel.DrawPanel.signal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {

	private ImageIcon ic_Choose, ic_paint, ic_Circle, ic_Pen, ic_Rec, ic_era, ic_Text, ic_Resize, ic_pixelate,
			ic_LeftRight, ic_UpDown, ic_LRUD, ic_INIT, ic_ROT;
	private JButton button_Choose, button_Paint, button_Pen, button_Circle, button_Rec, button_Erager, button_Text,
			button_Resize, button_pixelate, button_LeftRight, button_UpDown, button_LRUD, button_INIT, button_ROT;

	public LeftPanel() {
		this.setBackground(Color.BLACK);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		ic_Choose = new ImageIcon("image\\choice.png");
		ic_Resize = new ImageIcon("image\\resize.png");
		ic_paint = new ImageIcon("image\\paint.png");
		ic_Pen = new ImageIcon("image\\pen.png");
		ic_Circle = new ImageIcon("image\\circle.png");
		ic_Rec = new ImageIcon("image\\square.png");
		ic_era = new ImageIcon("image\\eraser.png");
		ic_Text = new ImageIcon("image\\text.png");
		ic_pixelate = new ImageIcon("image\\pixelate.png");
		ic_LeftRight = new ImageIcon("image\\LEFTRIGHT.png");
		ic_UpDown = new ImageIcon("image\\updown.png");
		ic_LRUD = new ImageIcon("image\\LRUD.png");
		ic_INIT = new ImageIcon("image\\init.png");
		ic_ROT = new ImageIcon("image\\rot.png");

		button_Choose = new JButton(ic_Choose);
		button_Resize = new JButton(ic_Resize);
		button_Paint = new JButton(ic_paint);
		button_Pen = new JButton(ic_Pen);
		button_Circle = new JButton(ic_Circle);
		button_Rec = new JButton(ic_Rec);
		button_Erager = new JButton(ic_era);
		button_Text = new JButton(ic_Text);
		button_pixelate = new JButton(ic_pixelate);
		button_LeftRight = new JButton(ic_LeftRight);
		button_UpDown = new JButton(ic_UpDown);
		button_LRUD = new JButton(ic_LRUD);
		button_INIT = new JButton(ic_INIT);
		button_ROT = new JButton(ic_ROT);

		button_Choose.setName("choose");
		button_Choose.setBackground(Color.BLACK);
		button_Choose.setBorderPainted(false);
		button_Choose.setFocusPainted(false);
		button_Resize.setName("resize");
		button_Resize.setBackground(Color.BLACK);
		button_Resize.setBorderPainted(false);
		button_Resize.setFocusPainted(false);
		button_Paint.setName("paint");
		button_Paint.setBackground(Color.BLACK);
		button_Paint.setBorderPainted(false);
		button_Paint.setFocusPainted(false);
		button_Pen.setName("pen");
		button_Pen.setBackground(Color.BLACK);
		button_Pen.setBorderPainted(false);
		button_Pen.setFocusPainted(false);
		button_Circle.setName("circle");
		button_Circle.setBackground(Color.BLACK);
		button_Circle.setBorderPainted(false);
		button_Circle.setFocusPainted(false);
		button_Rec.setName("rec");
		button_Rec.setBackground(Color.BLACK);
		button_Rec.setBorderPainted(false);
		button_Rec.setFocusPainted(false);
		button_Erager.setName("era");
		button_Erager.setBackground(Color.BLACK);
		button_Erager.setBorderPainted(false);
		button_Erager.setFocusPainted(false);
		button_Text.setName("text");
		button_Text.setBackground(Color.BLACK);
		button_Text.setBorderPainted(false);
		button_Text.setFocusPainted(false);
		button_pixelate.setName("pixelate");
		button_pixelate.setBackground(Color.BLACK);
		button_pixelate.setBorderPainted(false);
		button_pixelate.setFocusPainted(false);
		button_LeftRight.setName("LeftRight");
		button_LeftRight.setBackground(Color.BLACK);
		button_LeftRight.setBorderPainted(false);
		button_LeftRight.setFocusPainted(false);
		button_UpDown.setName("UpDown");
		button_UpDown.setBackground(Color.BLACK);
		button_UpDown.setBorderPainted(false);
		button_UpDown.setFocusPainted(false);
		button_LRUD.setName("LRUD");
		button_LRUD.setBackground(Color.BLACK);
		button_LRUD.setBorderPainted(false);
		button_LRUD.setFocusPainted(false);
		button_INIT.setName("INIT");
		button_INIT.setBackground(Color.BLACK);
		button_INIT.setBorderPainted(false);
		button_INIT.setFocusPainted(false);
		button_ROT.setName("ROT");
		button_ROT.setBackground(Color.BLACK);
		button_ROT.setBorderPainted(false);
		button_ROT.setFocusPainted(false);

		button_Choose.addActionListener(this);
		button_Resize.addActionListener(this);
		button_Paint.addActionListener(this);
		button_Pen.addActionListener(this);
		button_Circle.addActionListener(this);
		button_Rec.addActionListener(this);
		button_Erager.addActionListener(this);
		button_Text.addActionListener(this);
		button_pixelate.addActionListener(this);
		button_LeftRight.addActionListener(this);
		button_UpDown.addActionListener(this);
		button_LRUD.addActionListener(this);
		button_INIT.addActionListener(this);
		button_ROT.addActionListener(this);

		this.add(button_Choose);
		this.add(button_Resize);
		this.add(button_Paint);
		this.add(button_Pen);
		this.add(button_Circle);
		this.add(button_Rec);
		this.add(button_Erager);
		this.add(button_Text);
		this.add(button_Text);
		this.add(button_pixelate);
		this.add(button_UpDown);
		this.add(button_LRUD);
		this.add(button_INIT);
		this.add(button_ROT);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton currentButton = (JButton) e.getSource();

		switch (currentButton.getName()) {
		case "choose":
			Information.setCurrentMode(Information.MODE_MOVE);
			break;
		case "resize":
			Information.setCurrentMode(Information.MODE_RESIZE);
			break;
		case "paint":
			Information.setCurrentMode(Information.MODE_PAINT);
			break;
		case "pen":
			Information.setCurrentMode(Information.MODE_PEN);
			break;
		case "circle":
			Information.setCurrentMode(Information.MODE_DRAW_CIRCLE);
			break;
		case "rec":
			Information.setCurrentMode(Information.MODE_DRAW_REC);
			break;
		case "era":
			Information.setCurrentMode(Information.MODE_ERASE);
			break;
		case "text":
			Information.setCurrentMode(Information.MODE_TEXT);
			break;
		case "pixelate":
			Information.setCurrentMode(Information.MODE_PIXELATE);
			System.out.println("Pixelate Button Clicked");
			break;
		case "LeftRight":
			Information.setCurrentMode(Information.MODE_LeftRight);
			signal = 3;
			break;
		case "UpDown":
			Information.setCurrentMode(Information.MODE_UpDown);
			signal = 2;
			break;
		case "LRUD":
			Information.setCurrentMode(Information.MODE_LRUD);
			signal = 4;
			break;
		case "INIT":
			Information.setCurrentMode(Information.MODE_INIT);
			signal = 1;
			break;
		case "ROT":
			Information.setCurrentMode(Information.MODE_ROT);
			signal = 5;
			break;
		default:
			break;
		}

	}
}
