package es.upm.fi.emse;

import java.util.List;

public class Game {
	protected AssemblyLine assemblyLine;
	protected List<Recipe> recipes;

	public Game(AssemblyLine assemblyLine, List<Recipe> recipes) {
		this.assemblyLine = assemblyLine;
		this.recipes = recipes;
	}

	public void start() {

	}
}
