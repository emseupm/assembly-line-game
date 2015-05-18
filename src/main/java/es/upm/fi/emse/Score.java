package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Score extends Component {

	private static final long serialVersionUID = -6047192677652438205L;

	private int padding = 10;
	private long currentScore = 1000;
	private int currentTime = 30;

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("SCORE", padding * 2, padding * 2);

		g.setColor(Color.BLACK);

		Font font = new Font("Arial", Font.PLAIN, 36);
		g.setFont(font);

		paintScore(g);
		paintTime(g);
	}

	private void paintScore(Graphics g) {
		paintText(g, currentScore + "", padding * 2, padding * 2, false);
	}

	private void paintTime(Graphics g) {
		String text = getTimeString(currentTime);
		paintText(g, text, getWidth() - padding * 2 , padding * 2, true);
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

	private String getTimeString(int time) {
		return String.format("%02d:%02d", time / 60, time % 60);
	}

}
