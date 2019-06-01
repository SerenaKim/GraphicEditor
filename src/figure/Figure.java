package figure;

import Information.Information;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable, Cloneable {

	// protected Color figureColor = Color.white;
	protected Color lineColor = Color.black;
	protected Paint figurePaint;
	protected GradientPaint figureGra;

	public Figure() {
		figurePaint = Information.getCurrentColor();
		// lineColor=Information.getlineColor();
	}

	public void setFigurePaint(Paint a) {
		figurePaint = a;
	}

	public void setLineColor(Color color) {
		this.lineColor = color;
	}

	public Paint getFigureColor() {
		return figurePaint;
	}

	public abstract void moveTo(int curX, int curY);

	public abstract void setFigureSize(int width, int height);

	public abstract int getSize();

	public abstract void drawFigure(Graphics2D g);

	public abstract void calcFigure(int currentX, int currentY);

	public abstract Figure clone();

}
