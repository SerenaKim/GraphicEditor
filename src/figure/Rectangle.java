package figure;

import java.awt.*;

public class Rectangle extends RecType {

	public Rectangle(int startX, int startY, int width, int height) {
		super(startX, startY, width, height);

	}

	@Override
	public void drawFigure(Graphics2D g) {
		g.setPaint(figurePaint);
		g.fillRect(X, Y, width, height);
		g.setColor(lineColor);
		g.setStroke(new BasicStroke(2));
		g.drawRect(X, Y, width, height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	@Override
	public Figure clone() {
		Rectangle obj = new Rectangle(0, 0, 0, 0);
		obj.startX = startX;
		obj.startY = startY;
		obj.width = width;
		obj.height = height;
		obj.figurePaint = figurePaint;
		obj.X = X;
		obj.Y = Y;

		return obj;
	}

}
