package Information;

import SubPanel.DrawPanel;
import figure.Figure;

import java.awt.*;

public class Information {

	public static final String PROGRAM_NAME = "Graphic Editor";
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 1000;

	public static final int MODE_DRAW_REC = 1;
	public static final int MODE_DRAW_CIRCLE = 3;
	public static final int MODE_ERASE = 5;
	public static final int MODE_TEXT = 6;
	public static final int MODE_MOVE = 7;
	public static final int MODE_PEN = 8;
	public static final int MODE_PAINT = 9;
	public static final int MODE_RESIZE = 10;
	public static final int MODE_PIXELATE = 13; 
	public static final int MODE_LeftRight = 14; 
	public static final int MODE_UpDown = 15; 
	public static final int MODE_LRUD = 16; 
	public static final int MODE_INIT = 17; 
	public static final int MODE_ROT = 18; 
	public static final int IS_EMPTY = -1;
	public static final int IS_ERAGER = 0;
	public static final int IS_FIGURE = 1;

	public static Color backgroundColor = new Color(255, 255, 255);

	private static int textStyle = Font.PLAIN;

	private static int textSize = 10;
	private static int LineSize = 1;
	private static Figure currentFigure = null;
	private static DrawPanel currentPanel = null;
	private static int DrawFrame_Count = 1;
	private static int CurrentMode = 19;
	private static Color currentColor = new Color(0, 0, 0);
	private static Color beforeColor = new Color(0, 0, 0);
	private static GradientPaint gra;

	private static Color lineColor = new Color(0, 0, 0);

	public static void setTextStyle(int font) {
		textStyle = font;
	}

	public static int gettextStyle() {
		return textStyle;
	}

	public static int getTextSize() {
		return textSize;
	}

	public static void setTextSize(int size) {
		textSize = size;
	}

	public static int getLineSize() {
		return LineSize;
	}

	public static void setLineSize(int size) {
		LineSize = size;
	}

	public static Figure getCurrentFigure() {
		return currentFigure;
	}

	public static void setCurrentFigure(Figure cur) {
		currentFigure = cur;
	}

	public static void setCurrentpanel(DrawPanel current) {
		currentPanel = current;
	}

	public static DrawPanel getCurrentJPanel() {
		return currentPanel;
	}

	public static int getDrawFrame_Count() {
		return DrawFrame_Count;
	}

	public static void addDrawFrame_Count() {
		DrawFrame_Count++;
	}

	public static String getCurrentModeToString() {
		switch (CurrentMode) {
		case MODE_DRAW_REC:
			return "MODE_DRAW_REC";
		case MODE_DRAW_CIRCLE:
			return "MODE_DRAW_CIRCLE";
		case MODE_ERASE:
			return "MODE_ERASE";
		case MODE_TEXT:
			return "MODE_TEXT";
		case MODE_MOVE:
			return "MODE_MOVE";
		case MODE_PEN:
			return "MODE_PEN";
		case MODE_PAINT:
			return "MODE_PAINT";
		case MODE_RESIZE:
			return "MODE_RESIZE";
		case MODE_LeftRight:
			return "MODE_LeftRight"; 
		case MODE_UpDown:
			return "MODE_UpDown"; 
		case MODE_LRUD:
			return "MODE_LRUD";
		case MODE_INIT:
			return "MODE_INIT";
		case MODE_ROT:
			return "MODE_ROT"; //
		default:
			return "Select Mode plz";
		}

	}

	public static int getCurrentMode() {
		return CurrentMode;
	}

	public static void setCurrentMode(int mode) {
		CurrentMode = mode;
	}

	public static Color getBeforeColor() {
		return beforeColor;
	}

	public static Color getCurrentColor() {
		return currentColor;
	}

	public static Color getLineColor() {
		return lineColor;
	}

	public static void setCurrentColor(int R, int G, int B, int A) {
		Color changeColor = new Color(R, G, B, A);
		beforeColor = currentColor;
		currentColor = changeColor;
		if (Information.getCurrentMode() == Information.MODE_PAINT) {
			if (Information.getCurrentFigure() != null) {
				Information.getCurrentFigure().setFigurePaint(currentColor);
				Information.getCurrentJPanel().repaint();
			}
		}
	}

}
