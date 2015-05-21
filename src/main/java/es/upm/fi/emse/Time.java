package es.upm.fi.emse;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Time extends Component {

	private static final long serialVersionUID = -4861918983514281668L;
	private int currentTime = 30;
	private int padding = 0;

	public Time() {
		new Thread(new Runnable() {
			public void run() {
				while (currentTime > 0) {
					currentTime--;
					System.out.println("time" + currentTime);
					getParent().invalidate();
					getParent().repaint(getX(), getY(), getWidth(), getHeight());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private String getTimeString(int time) {
		System.out.println(String.format("%02d:%02d", time / 60, time % 60));
		return String.format("%02d:%02d", time / 60, time % 60);
	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("Arial", Font.PLAIN, 36);
		g.setFont(font);
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
}
