package es.upm.fi.emse;

import java.util.ArrayList;

public class HotDogRecipe extends Recipe {

	public HotDogRecipe() {
		super(new Product(), new ArrayList<Task>());

		addTask(new Bread());
		addTask(new Sausage());
		addTask(new Ketchup());
	}

	private void addTask(Part part) {
		Task task = new Task();
		task.setPart(part);
		tasks.add(task);
	}

}
