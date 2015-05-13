package es.upm.fi.emse;

import java.util.ArrayList;
import java.util.List;

public class Station {
	protected List<Task> tasks = new ArrayList<Task>();

	public void addTask(Task task) {
		tasks.add(task);
	}
}
