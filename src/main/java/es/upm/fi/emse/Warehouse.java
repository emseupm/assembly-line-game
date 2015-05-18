package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Component {

	private static final long serialVersionUID = -4985756162707607745L;

	private List<Part> parts = new ArrayList<Part>();

	protected int padding = 25;

	public Warehouse() {
		setupParts();
	}

	private void setupParts(){
		parts.add(new Bread());
		parts.add(new Sausage());
		parts.add(new Ketchup());
		parts.add(new HotSauce());

		layoutParts();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				layoutParts();
			}
		});
	}

	private void layoutParts() {
		int partWidth = (getWidth() - padding * 2) / parts.size();
		for (int i = 0; i < parts.size(); i++) {
			Part part = parts.get(i);
			part.setBounds(padding + i * (partWidth), padding, partWidth, getHeight() - padding * 2);
		}
	}

	public void paint(Graphics g) {
		int padding = 10;

		g.setColor(Color.decode("0x6cacdd"));
		g.fillRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.setColor(Color.decode("0x5a90ba"));
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.setColor(Color.WHITE);
		g.drawString("WAREHOUSE", padding * 3, padding * 3);

		for (Part part : parts) {
			Rectangle bounds = part.getBounds();
			part.paint(g.create(bounds.x, bounds.y, bounds.width, bounds.height));
		}
	}

}
