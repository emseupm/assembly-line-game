package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Station extends Component {
	private static final long serialVersionUID = 1L;
	
	protected List<Task> tasks = new ArrayList<Task>();
	
	public void setTasks(List<Task> tasks){
		this.tasks = tasks;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);

		int padding = 10;
		int width = getWidth() - padding * 2;
		int height = getHeight() - padding * 2;
		Graphics content = g.create(padding, padding, width, height);

		int rectWidth  = width * 3 / 4;
		int rectHeight = height / 2;

		paintFrontFace(content, rectWidth, rectHeight);
		paintTopFace(content, rectWidth, rectHeight);
		paintRightFace(content, rectWidth, rectHeight);
	}

	private void paintFrontFace(Graphics g, int rectWidth, int rectHeight) {
		g.setColor(Color.decode("0x6cacdd"));
		g.fillRect(0, g.getClipBounds().height - rectHeight, rectWidth, rectHeight);

		g.setColor(Color.decode("0x5a90ba"));
		g.drawRect(0, g.getClipBounds().height - rectHeight, rectWidth, rectHeight);

		paintLabel(g.create(0, g.getClipBounds().height - rectHeight, rectWidth, rectHeight));
	}

	private void paintLabel(Graphics g) {
		String text = "Station";
		Rectangle2D stringBounds = g.getFontMetrics().getStringBounds(text, g);

		int width = g.getClipBounds().width;
		int height = g.getClipBounds().height;
		int stringWidth = (int) stringBounds.getWidth();
		int stringHeight = (int) stringBounds.getHeight();

		int x = (width - stringWidth) / 2;
		int y = (height - stringHeight) / 2;

		g.setColor(Color.WHITE);
		g.drawString(text, x, y + g.getFontMetrics().getAscent());
	}

	private void paintRightFace(Graphics g, int rectWidth, int rectHeight) {
		Polygon rightFace = new Polygon();
		rightFace.addPoint(rectWidth, g.getClipBounds().height);
		rightFace.addPoint(rectWidth, g.getClipBounds().height - rectHeight);
		rightFace.addPoint(g.getClipBounds().width, 0);
		rightFace.addPoint(g.getClipBounds().width, rectHeight);
		g.setColor(Color.decode("0x5a90ba"));
		g.fillPolygon(rightFace);

		g.setColor(Color.decode("0x5a90ba"));
		g.drawPolygon(rightFace);
	}

	private void paintTopFace(Graphics g, int rectWidth, int rectHeight) {
		Polygon topFace = new Polygon();
		topFace.addPoint(0, g.getClipBounds().height - rectHeight);
		topFace.addPoint(g.getClipBounds().width - rectWidth, 0);
		topFace.addPoint(g.getClipBounds().width, 0);
		topFace.addPoint(rectWidth, g.getClipBounds().height - rectHeight);
		g.setColor(Color.decode("0x8cbde4"));
		g.fillPolygon(topFace);

		g.setColor(Color.decode("0x5a90ba"));
		g.drawPolygon(topFace);
	}
}
