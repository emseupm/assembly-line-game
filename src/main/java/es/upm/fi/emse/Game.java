package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class Game extends Frame {

	private static final int DEFAULT_HEIGHT = 300;
	private static final int DEFAULT_WIDTH = 300;

	private static final long serialVersionUID = -1070413246769754490L;

	protected AssemblyLine assemblyLine;
	protected List<Recipe> recipes;
	protected Score score = new Score();
	protected Warehouse warehouse = new Warehouse();

	public Game(AssemblyLine assemblyLine, List<Recipe> recipes) {
		super("Assembly Line Game");

		this.assemblyLine = assemblyLine;
		this.recipes = recipes;

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
		int y = 30; // guessing title bar height
		int width = getWidth() - x;
		int height = getHeight() - y;

		score.setBounds(x, y, width, height / 3);
		assemblyLine.setBounds(x, y + height / 3, width, height / 3);
		warehouse.setBounds(0, y + 2 * height / 3, width, height / 3);
	}

	public void start() {
		setVisible(true);
	}

}
