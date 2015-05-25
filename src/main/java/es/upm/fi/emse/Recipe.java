package es.upm.fi.emse;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class Recipe extends JComponent {

	private static final long serialVersionUID = -5072709853087281668L;

	protected Product product;
	protected List<Task> tasks;

	public Recipe(Product product, List<Task> tasks) {
		 this.product = product;
		 this.tasks = tasks;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Task task = tasks.get(0);

		if (task != null) {
			task.setSize(getSize());
			task.paint(g);
		}
	}
}
