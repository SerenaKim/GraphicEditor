package figure;

import Information.Information;

import java.awt.*;
import java.util.ArrayList;

public class Pen extends PenType {
	private int strokeSize = 1;

	public Pen(int firstX, int firstY) {
		super(firstX, firstY);
		strokeSize = Information.getLineSize();
	}

	@Override
	public void drawFigure(Graphics2D g) {
		g.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setPaint(figurePaint);
		for (PenTypeTracePoint current : points) {
			g.drawLine(current.prePoints.x, current.prePoints.y, current.LastPoints.x, current.LastPoints.y);
		}
	}

	@Override
	public String toString() {
		return "Pen [lineColor=" + lineColor + "]";
	}

	@Override
	public Figure clone() {
		Pen obj = new Pen(0, 0);
		obj.preX = preX;
		obj.preY = preY;
		obj.points = (ArrayList<PenTypeTracePoint>) points.clone();
		return obj;
	}

}
