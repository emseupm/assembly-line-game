package es.upm.fi.emse;

import java.util.List;

public class Recipe {
	protected Product product;
	protected List<Task> tasks;
	
	 public Recipe(Product product, List<Task> tasks) {

		 this.product = product;
		 this.tasks = tasks;
	}	
	
	 
	 public List<Task> getTasks() {
		return tasks;
	}
}
