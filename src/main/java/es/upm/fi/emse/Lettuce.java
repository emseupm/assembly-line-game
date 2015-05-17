package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.Color;

public class Lettuce extends Part {

	private int width;
	private int height;
	
	public Lettuce() {
		this.color = new Color(50,205,50);
		this.width = 20 * this.Size;
		this.height = 50 * this.Size;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawRect(getX(), getY(), this.width, this.height);
		g.fillRect(getX(), getY(), this.width, this.height);
	}

}
