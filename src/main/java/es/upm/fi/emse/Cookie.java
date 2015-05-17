package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.Color;

public class Cookie extends Part {

	private int diameter;
	
	public Cookie() {
		this.color = new Color(218,165,32);
		this.diameter = 50 * this.Size;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawOval(getX(), getY(), diameter, diameter);
		g.fillOval(getX(), getY(), diameter, diameter);
	}
	
}