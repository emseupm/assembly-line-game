package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Score extends Container implements Observer {

	private static final long serialVersionUID = -6047192677652438205L;

	private BufferedImage image;
	private int padding = 10;
	private long currentScore = 1000;
	private Time time;

	public Score() {
		setupComponents();
	}

	private void setupComponents() {
		time = new Time();
		add(time);

		layoutComponents();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				layoutComponents();
			}
		});
	}

	private void layoutComponents() {
		int width = getWidth() - padding * 2;
		int height = getHeight() - padding * 2;

		time.setBounds(width / 3 + padding, padding, width / 3, height / 3);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLUE);

		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("SCORE", padding * 2, padding * 2);

		g.setColor(Color.BLACK);

		Font font = new Font("Arial", Font.PLAIN, 36);
		g.setFont(font);

		paintScore(g);

		if (image != null) { 
			g.drawImage(image, (getWidth() - image.getWidth()) / 2, 60, 100, 100, this);
		}
	}

	private void paintScore(Graphics g) {
		paintText(g, currentScore + "", padding * 2, padding * 2, false);
	}

	private void paintText(Graphics g, String text, int x, int y, boolean rightAligned) {
		Rectangle2D stringBounds = g.getFontMetrics().getStringBounds(text, g);
		int stringWidth  = (int) stringBounds.getWidth();
		int stringHeight = (int) stringBounds.getHeight();

		if (rightAligned) {
			x -= stringWidth;
		}

		g.drawString(text, x, y + stringHeight);
	}
	
	public void taskCorrect() {
		System.out.println("A part has been put in the right place");
		currentScore += 150;
		setImage("correct.png");		
	}

	public void taskIncorrect(){
		System.out.println("A part has been put in the wrong place");
		currentScore -= 100;
		setImage("wrong.jpg");
	}

	private void setImage(String name) {	
		try {
			image = ImageIO.read(getClass().getResourceAsStream(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
