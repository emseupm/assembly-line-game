package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.Color;

public class Coffee extends Part {

	private int width;
	private int height;
	
	public Coffee() {
		this.color = new Color(222,184,135);
		this.width = 30 * this.Size;
		this.height = 50 * this.Size;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawRect(getX(), getY(), this.width, this.height);
		g.fillRect(getX(), getY(), this.width, this.height);
	}
}
