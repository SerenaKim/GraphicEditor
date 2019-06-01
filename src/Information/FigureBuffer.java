package Information;

import figure.Figure;

import java.util.Vector;

public class FigureBuffer {
	private static FigureBuffer instance;
	private Vector<Figure> buffer = new Vector<Figure>();

	public static FigureBuffer getInstance() {
		if (instance == null)
			instance = new FigureBuffer();
		return instance;
	}

	public boolean isEmpty() {
		return buffer.isEmpty();
	}

	public void replaceBuffer(Vector<Figure> newBuffer) {
		buffer.clear();
		for (Figure cur : newBuffer) {
			buffer.add(cur.clone());
		}

	}

	public Vector<Figure> getBuffer() {
		return (Vector<Figure>) buffer.clone();
	}

	public void replaceBuffer(Figure currentFigure) {
		buffer.clear();
		buffer.add((Figure) currentFigure.clone());

	}

	public void clearBuffer() {
		buffer.clear();
	}

}
