package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class AssemblyLine extends JComponent implements StationListener {

	private static final long serialVersionUID = -7209808105752155582L;

	protected List<Station> stations;
	protected List<RecipeLoader> recipeLoaders;
	protected int totalStations = 3;
	protected int padding = 10;

	private List<AssemblyLineListener> assemblyLineListeners = new ArrayList<AssemblyLineListener>();

	public AssemblyLine() {
		stations = new ArrayList<Station>();
		setupStations();
	}

	private void setupStations() {
		for (int i = 0; i < totalStations; i++) {
			Station station = new Station();
			stations.add(station);
			add(station);

			station.addStationListener(this);
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

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("ASSEMBLY LINE", padding * 2, padding * 2);
	}

	public void workCompleted(Station station) {
		if (station == stations.get(0)) {
			notifyFirstStationFreed();
		}
	}

	public synchronized void addAssemblyLineListener(AssemblyLineListener assemblyLineListener) {
		assemblyLineListeners.add(assemblyLineListener);
	}

	public synchronized void notifyFirstStationFreed() {
		for (AssemblyLineListener assemblyLineListener : assemblyLineListeners ) {
			assemblyLineListener.firstStationFreed(this);
		}
	}

	public synchronized void notifyStationSelected(Station station) {
		for (AssemblyLineListener assemblyLineListener : assemblyLineListeners ) {
			assemblyLineListener.stationSelected(station);
		}
	}

	public void load(Recipe recipe) {
		RecipeLoader firstRecipeLoader = recipeLoaders.get(0);
		firstRecipeLoader.load(recipe);
	}

	public void stationSelected(Station station) {
		notifyStationSelected(station);
	}
}
