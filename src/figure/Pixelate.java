package figure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Pixelate extends RecType {

	public BufferedImage bi = null;
	int x;
	int y;
	int w;
	int h;

	public Pixelate(int startX, int startY, int width, int height) {
		super(startX, startY, width, height);
		x = startX;
		y = startY;
		w = width;
		h = height;
	}

	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}

	private static final long serialVersionUID = 1L;

	Color getAverageColor(BufferedImage tile) {
		int twidth = bi.getWidth();
		int theight = bi.getHeight();
		double pixSize = twidth * theight;
		double sumRed = 0;
		double sumGreen = 0;
		double sumBlue = 0;
		Color pixColor = null;
		for (int i = 0; i < theight; i++) {
			for (int j = 0; j < twidth; j++) {
				try {
					pixColor = new Color(tile.getRGB(i, j));
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
				sumRed += pixColor.getRed();
				sumGreen += pixColor.getGreen();
				sumBlue += pixColor.getBlue();
			}
		}
		int avgRed = (int) (sumRed / pixSize);
		int avgGreen = (int) (sumGreen / pixSize);
		int avgBlue = (int) (sumBlue / pixSize);
		// System.out.println("avgRed : " + avgRed + "avgGreen : " + avgGreen + "avgBlue : " + avgBlue);
		return new Color(avgRed, avgGreen, avgBlue);
	}

	@Override
	public void drawFigure(Graphics2D g) {
		BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		if (bi != null) {
			Color color = getAverageColor(bi);
			System.out.println("x : " + x + "y : " + y);
			int[] data = new int[width * height];
			int i = 0;
			for (int y = 0; y < height; y++) {
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				for (int x = 0; x < width; x++) {
					data[i++] = (red << 16) | (green << 8) | blue;
				}
			}

			result.setRGB(0, 0, width, height, data, 0, width);
			g.setPaint(figurePaint);
			g.drawImage(result, x, y, w, h, null);
		}
	}

	@Override
	public Figure clone() {
		Pixelate obj = new Pixelate(0, 0, 0, 0);
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
