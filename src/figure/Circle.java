package figure;

import java.awt.*;

public class Circle extends RecType {

	public Circle(int startX, int startY, int width, int height) {
		super(startX, startY, width, height);
		System.out.println("Circle created");
	}

	@Override
	public void drawFigure(Graphics2D g) {
		// g.setColor(figureColor);
		g.setPaint(figurePaint);
		g.fillOval(X, Y, width, height);
		g.setColor(lineColor);
		g.setStroke(new BasicStroke(2));
		g.drawOval(X, Y, width, height);
	}

	@Override
	public String toString() {
		return "Circle [width=" + width + ", height=" + height + "]";
	}

	@Override
	public Figure clone() {
		Circle obj = new Circle(0, 0, 0, 0);
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
