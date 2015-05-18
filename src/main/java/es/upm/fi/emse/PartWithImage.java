package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PartWithImage extends Part {

	private static final long serialVersionUID = -3956780940397892420L;

	private BufferedImage image;

	private int padding = 10;

	public PartWithImage(String filename) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		int width  = getWidth() - padding * 2;
		int height = getHeight() - padding  * 2;

		double scale = Math.min(1.0 * width / image.getWidth(), 1.0 * height / image.getHeight());

		int newWidth  = (int) Math.round(scale * image.getWidth());
		int newHeight = (int) Math.round(scale * image.getHeight());

		g.drawImage(image, (getWidth() - newWidth) / 2, (getHeight() - newHeight) / 2, newWidth, newHeight, this);
	}

}
