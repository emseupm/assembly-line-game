package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Warehouse extends Component {

	private static final long serialVersionUID = -4985756162707607745L;

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("WAREHOUSE", padding * 2, padding * 2);
	}

}
