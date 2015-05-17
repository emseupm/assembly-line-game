package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.Color;

public class Meatball extends Part {
	
	private int diameter;
	
	public Meatball() {
		this.color = new Color(160,82,45);
		this.diameter = 50 * this.Size;
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.drawOval(getX(), getY(), diameter, diameter);
		g.fillOval(getX(), getY(), diameter, diameter);
	}

}
