package figure;

import Information.Information;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends PenType {
	public Eraser(int firstX, int firstY) {
		super(firstX, firstY);
	}

	@Override
	public void drawFigure(Graphics2D g) {
		g.setColor(Information.backgroundColor);
		g.setStroke(new BasicStroke(25, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		// g.setColor(Information.backgroundColor);
		for (PenTypeTracePoint current : points) {
			g.drawLine(current.prePoints.x, current.prePoints.y, current.LastPoints.x, current.LastPoints.y);
		}
	}

	@Override
	public String toString() {
		return "Eraser";
	}

	@Override
	public Figure clone() {
		Eraser obj = new Eraser(0, 0);
		obj.preX = preX;
		obj.preY = preY;
		obj.points = (ArrayList<PenTypeTracePoint>) points.clone();
		return obj;
	}
}
