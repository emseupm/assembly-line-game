package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine extends Component {

	private static final long serialVersionUID = -7209808105752155582L;

	protected List<Station> stations;
	protected List<RecipeLoader> recipeLoaders;
	protected int totalStations = 3;
	protected int padding = 10;
	
	public AssemblyLine() {
		stations = new ArrayList<Station>();
		setupStations();
	}
	
	private void setupStations() {
		for (int i = 0; i < totalStations; i++) {
			Station station = new Station();
			stations.add(station);
		}

		layoutStations();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				layoutStations();
			}
		});
	}

	private void layoutStations() {
		int stationWidth = (getWidth() - padding * 2) / totalStations;
		for (int i = 0; i < totalStations; i++) {
			Station station = stations.get(i);
			station.setBounds(padding + i * (stationWidth), padding, stationWidth, getHeight() - padding * 2);
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("ASSEMBLY LINE", padding * 2, padding * 2);

		for (Station station : stations) {
			Rectangle bounds = station.getBounds();
			station.paint(g.create(bounds.x, bounds.y, bounds.width, bounds.height));
		}
	}
}
