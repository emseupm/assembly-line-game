package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class AssemblyLine extends JComponent implements StationListener, Observer {

	private static final long serialVersionUID = -7209808105752155582L;

	protected List<Station> stations = new ArrayList<Station>();
	protected List<RecipeLoader> recipeLoaders = new ArrayList<RecipeLoader>();
	protected int totalStations = 3;
	protected int padding = 10;

	private List<AssemblyLineListener> assemblyLineListeners = new ArrayList<AssemblyLineListener>();

	private Observer taskObserver;

	public AssemblyLine() {
		setupStations();
	}

	private void setupStations() {
		for (int i = 0; i < totalStations; i++) {
			Station station = new Station();
			stations.add(station);
			add(station);

			RecipeLoader recipeLoader = new RecipeLoader(station);
			recipeLoaders.add(recipeLoader);

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

	public void load(Recipe recipe) {
		RecipeLoader firstRecipeLoader = recipeLoaders.get(0);
		for (Task task : recipe.getTasks()) {
			task.addObserver(this);
		}
		firstRecipeLoader.load(recipe);
	}

	public void taskCorrect() {
		if (taskObserver != null) {
			taskObserver.taskCorrect();
		}
	}

	public void taskIncorrect() {
		if (taskObserver != null) {
			taskObserver.taskIncorrect();
		}
	}

	public void setTaskObserver(Observer taskObserver) {
		this.taskObserver = taskObserver;
	}

}
