package figure;

import javax.swing.*; 
import java.awt.*;
import java.awt.image.BufferedImage;
import Information.Information;
import static SubPanel.DrawPanel.signal;

public class Picture extends RecType {
	private BufferedImage bufferedImage;
	private String angle = null;
	private double ang = 0;

	public Picture(int startX, int startY, int width, int height) {
		super(startX, startY, width, height);
	}

	public void setGraphics(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public void drawFigure(Graphics2D g) {
		if (bufferedImage == null) {
			System.out.println("Error : bufferedImage is null; Please call setGraphics function before call this function!");
			return;
		}
		int imgw = bufferedImage.getWidth();
		int imgh = bufferedImage.getHeight();
		switch (signal) {
		case 0:
			g.drawImage(bufferedImage, 0, 0, imgw, imgh, 0, 0, imgw, imgh, null);

			break;
		case 1:
			g.drawImage(bufferedImage, 0, 0, imgw, imgh, 0, 0, imgw, imgh, null);

			break;
		case 2:
			g.drawImage(bufferedImage, 0, imgh, imgw, 0, 0, 0, imgw, imgh, null);

			break;

		case 3: 
			g.drawImage(bufferedImage, imgw, 0, 0, imgh, 0, 0, imgw, imgh, null);

			break;
		case 4:
			g.drawImage(bufferedImage, imgw, imgh, 0, 0, 0, 0, imgw, imgh, null);

			break;
		case 5:
			if (Information.getCurrentMode() == Information.MODE_ROT)
			{
				angle = JOptionPane.showInputDialog("angle is : ", angle);
				if (angle == null) {

				} else if (angle != null) {
					ang = Double.parseDouble(angle);
				}

			}
			g.rotate(Math.toRadians(ang), imgw / 2, imgh / 2);
			g.translate(0, 0);
			g.drawImage(bufferedImage, 0, 0, imgw, imgh, null);

			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "Picture [width=" + width + ", height=" + height + "]";
	}

	@Override
	public Figure clone() {
		return null;
	}
}
