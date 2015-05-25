package es.upm.fi.emse;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Game extends JFrame implements AssemblyLineListener, PartListener {

	private static final int DEFAULT_HEIGHT = 600;
	private static final int DEFAULT_WIDTH = 800;

	private static final long serialVersionUID = -1070413246769754490L;

	protected AssemblyLine assemblyLine;
	protected Score score = new Score();
	protected Warehouse warehouse = new Warehouse();
	protected Part selectedPart;
	protected Station selectedStation;

	public Game(AssemblyLine assemblyLine) {
		super("Assembly Line Game");

		this.assemblyLine = assemblyLine;
		assemblyLine.addAssemblyLineListener(this);

		warehouse.addPartListener(this);

		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setBackground(Color.WHITE);

		setupComponents();
	}

	private void setupComponents() {
		add(score);
		add(assemblyLine);
		add(warehouse);
		
		layoutComponents();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				layoutComponents();
			}
		});
	}

	private void layoutComponents() {
		int x = 0;
		int y = 0; // guessing title bar height
		int width = getWidth() - x;
		int height = getHeight() - y;

		score.setBounds(x, y, width, height / 3);
		assemblyLine.setBounds(x, y + height / 3, width, height / 3);
		warehouse.setBounds(0, y + 2 * height / 3, width, height / 3);
	}

	public void start() {
		setVisible(true);
	}

	public void firstStationFreed(AssemblyLine assemblyLine) {
		assemblyLine.load(new HotDogRecipe());
	}

	public void stationSelected(Station station) {
		selectedStation = station;
		System.out.println("Selected station: " + station);

		if (selectedPart != null) {
			station.accept(selectedPart);
		}
	}

	public void partSelected(Part part) {
		selectedPart = part;
		System.out.println("Selected part: " + part);
	}

}
