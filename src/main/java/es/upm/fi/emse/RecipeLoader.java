package es.upm.fi.emse;

public class RecipeLoader {
	protected Station station;

	public RecipeLoader(Station station) {
		this.station = station;
	}

	public void load(Recipe recipe) {
		station.setTasks(recipe.getTasks());
		station.setRecipe(recipe);

		station.invalidate();
		station.repaint();
	}
}
