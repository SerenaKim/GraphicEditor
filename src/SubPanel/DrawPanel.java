package SubPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Frame.MainFrame;
import Information.Information;
import SubFrame.RightDownInternalFrame;
import figure.Circle;
import figure.Eraser;
import figure.Figure;
import figure.Pen;
import figure.Pixelate;
import figure.Rectangle;
import figure.Text;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener, Serializable {
	public Vector<Figure> figureSet = new Vector<Figure>();
	private String filepath = null;
	private Stack<Vector<Figure>> figureStack = new Stack<Vector<Figure>>();
	private Stack<Vector<Figure>> figureCancelStack = new Stack<Vector<Figure>>();

	private int dragStartX, dragStartY;
	private Vector<Point> point = new Vector<>();
	private int[] X_point = new int[10];
	private int[] Y_point = new int[10];
	private int count = 0;
	public static int signal = 0;
	public BufferedImage image = null;

	public Stack<Vector<Figure>> getStack() {
		return this.figureStack;
	}

	public void setStack(Vector<Figure> vf) {
		figureStack.add(vf);
	}

	public DrawPanel() {
		Information.setCurrentpanel(this);
		this.setBackground(new Color(255, 255, 255));
		setVisible(true);
		//System.out.println(this.getName());

		this.setFocusable(true);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);

	}

	public void setImagePath(String path) throws IOException {
		File f = new File(path);
		image = ImageIO.read(f);
		System.out.println(path);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);

		for (Figure current : figureSet) {
			current.drawFigure(g2);
		}

	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		MainFrame.getInstance().setBottomLabel("X : " + e.getX() + " Y : " + e.getY());

		if (Information.getCurrentMode() == Information.MODE_MOVE) {
			if (Information.getCurrentFigure() != null) {
				int moveX = e.getX() - dragStartX;
				int moveY = e.getY() - dragStartY;
				Information.getCurrentFigure().moveTo(moveX, moveY);
				dragStartX = e.getX();
				dragStartY = e.getY();
				repaint();
			}

		} else if (Information.getCurrentMode() == Information.MODE_PAINT) {

		} else if (Information.getCurrentMode() == Information.MODE_RESIZE) {
			if (Information.getCurrentFigure() != null) {

				Information.getCurrentFigure().calcFigure(e.getX(), e.getY());
				repaint();
			}
		} else if (Information.getCurrentMode() == Information.MODE_PIXELATE) {

		} else {
			Figure current = figureSet.lastElement();
			figureSet.remove(figureSet.lastElement());
			drawCurrentFigureFunc(e, current);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		MainFrame.getInstance().setBottomLabel("X : " + e.getX() + " Y : " + e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Information.setCurrentpanel(this);
		RightDownInternalFrame.getInstance().setListItems(figureSet);
		if (Information.getCurrentMode() == Information.MODE_MOVE) {
			if (Information.getCurrentFigure() != null) {
				dragStartX = e.getX();
				dragStartY = e.getY();
			} else {
				JOptionPane.showMessageDialog(null, "Error : I can't find figure", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		} else if (Information.getCurrentMode() == Information.MODE_PAINT) {

			if (Information.getCurrentFigure() != null) {
				Information.getCurrentFigure().setFigurePaint(Information.getCurrentColor());
				repaint();
			} else {
				this.setBackground(Information.getCurrentColor());
				Information.backgroundColor = Information.getCurrentColor();
				repaint();
			}

		} else if (Information.getCurrentMode() == Information.MODE_PIXELATE) 
		{
			Pixelate pixelate = new Pixelate(e.getX() - 15, e.getY() - 15, 30, 30);
			System.out.println("image : " + image);
			BufferedImage i = image.getSubimage(e.getX() - 15, e.getY() - 15, 30, 30);
			pixelate.setBi(i);
			figureSet.addElement(pixelate);
			System.out.println(figureSet.size());
			repaint();
			System.out.println("Pixelate mouselistener clicked");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		MainFrame.getInstance().setBottomLabel("Out of Frame");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Information.setCurrentpanel(this);

		if (Information.getCurrentMode() == Information.MODE_MOVE) {
			if (Information.getCurrentFigure() != null) {
				dragStartX = e.getX();
				dragStartY = e.getY();
			} else {
				JOptionPane.showMessageDialog(null, "Error : I can't find figure", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		} else if (Information.getCurrentMode() == Information.MODE_PAINT) {

			if (Information.getCurrentFigure() != null) {
				
			} else {
				this.setBackground(Information.getCurrentColor());
				repaint();
			}
		}

		else if (Information.getCurrentMode() == Information.MODE_RESIZE) {

		} else {
			drawFigureFunc(e);

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		RightDownInternalFrame.getInstance().setListItems(figureSet);

		figureStack.push((Vector<Figure>) figureSet.clone());

		figureCancelStack.clear();

	}

	private void drawFigureFunc(MouseEvent e) {
		int mode = Information.getCurrentMode();
		switch (mode) {
		case Information.MODE_PEN:
			Pen pen = new Pen(e.getX(), e.getY());
			figureSet.addElement(pen);
			break;

		case Information.MODE_DRAW_REC:
			Rectangle rec = new Rectangle(e.getX(), e.getY(), 0, 0);
			figureSet.addElement(rec);
			break;
		case Information.MODE_DRAW_CIRCLE:
			Circle circle = new Circle(e.getX(), e.getY(), 0, 0);
			figureSet.addElement(circle);
			break;
		case Information.MODE_ERASE:
			Eraser eraser = new Eraser(e.getX(), e.getY());
			figureSet.addElement(eraser);
			break;
		case Information.MODE_TEXT:
			Text text = new Text(e.getX(), e.getY());
			figureSet.addElement(text);
			RightDownInternalFrame.getInstance().setListItems(figureSet);
			break;
		default:
			return;
		}
		repaint();
	}

	public void drawCurrentFigureFunc(MouseEvent e, Figure temp) {
		temp.calcFigure(e.getX(), e.getY());
		figureSet.addElement(temp);
		repaint();
	}

	public void changeVector(Vector<Figure> vector) {
		figureSet = vector;
	}

	public Vector<Figure> getVector() {
		return figureSet;
	}

	public void addVector(Vector<Figure> addData) {
		figureSet.addAll(addData);
		RightDownInternalFrame.getInstance().setListItems(figureSet);

		figureStack.push((Vector<Figure>) figureSet.clone());
		figureCancelStack.clear();
		repaint();
	}

	public void addVector(Figure addData) {
		figureSet.add((Figure) addData.clone());

		RightDownInternalFrame.getInstance().setListItems(figureSet);
		figureStack.push((Vector<Figure>) figureSet.clone());
		figureCancelStack.clear();
		repaint();
	}

	public void clearFigure() {
		figureSet.clear();
		figureStack.clear();
		figureCancelStack.clear();
		RightDownInternalFrame.getInstance().setListItems(figureSet);
		repaint();
	}

	public void deleteFigure(int idx) {
		figureStack.push((Vector<Figure>) figureSet.clone());
		figureCancelStack.clear();
		figureSet.remove(idx);
		RightDownInternalFrame.getInstance().setListItems(figureSet);

		repaint();
	}

	public void copyFigure(int idx) { 
		figureStack.push((Vector<Figure>) figureSet.clone());
		figureCancelStack.clear();
		figureSet.addElement(figureSet.elementAt(idx).clone()); 
		RightDownInternalFrame.getInstance().setListItems(figureSet);

		repaint();
	}

	public void popStackTrace() {
		if (figureStack.isEmpty()) {

			figureCancelStack.push((Vector<Figure>) figureSet.clone());
			figureSet.clear();
			repaint();
			RightDownInternalFrame.getInstance().setListItems(figureSet);
			JOptionPane.showMessageDialog(null, "Error : I can't find More Action", "ERROR", JOptionPane.ERROR_MESSAGE);

			return;
		} else {

			figureCancelStack.push((Vector<Figure>) figureSet.clone());

			if (figureSet.equals(figureStack.peek()))
				figureStack.pop();
			if (!figureStack.empty()) {
				figureSet = (Vector<Figure>) figureStack.peek().clone();
				figureStack.pop();
			} else {
				figureSet.clear();
			}

			RightDownInternalFrame.getInstance().setListItems(figureSet);
			repaint();
		}

	}

	public void popStackCaneStack() {
		if (figureCancelStack.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error : I can't find More Action", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		} else {

			figureStack.push((Vector<Figure>) figureSet.clone());
			figureSet = (Vector<Figure>) figureCancelStack.pop().clone();

			RightDownInternalFrame.getInstance().setListItems(figureSet);
			repaint();
		}

	}

}
