package es.upm.fi.emse;

import java.util.ArrayList;

public class HotDogRecipe extends Recipe {

	private static final long serialVersionUID = 8759189959527356490L;

	public HotDogRecipe() {
		super(new Product(), new ArrayList<Task>());

		Task task3 = new Task(new Ketchup(), null);
		Task task2 = new Task(new Sausage(), task3);
		Task task1 = new Task(new Bread(), task2);

		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task2);
	}

}
