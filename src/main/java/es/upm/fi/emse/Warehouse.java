package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

public class Warehouse extends JComponent {

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

		for (Part part : parts) {
			add(part);
		}

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

	@Override
	public void paintComponent(Graphics g) {
		int padding = 10;

		g.setColor(Color.decode("0x6cacdd"));
		g.fillRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.setColor(Color.decode("0x5a90ba"));
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.setColor(Color.WHITE);
		g.drawString("WAREHOUSE", padding * 3, padding * 3);
	}

	public void addPartListener(PartListener partListener) {
		for (Part part : parts) {
			part.addPartListener(partListener);
		}
	}

}
