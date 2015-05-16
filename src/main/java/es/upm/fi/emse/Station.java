package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Station extends Component{
	private static final long serialVersionUID = 1L;
	
	protected List<Task> tasks = new ArrayList<Task>();

	public void addTask(Task task) {
		tasks.add(task);
	}
	public void addTaskArray(List<Task> tasks){
		this.tasks = tasks;
	}
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("STATION", padding * 2, padding * 2);
	}
}
