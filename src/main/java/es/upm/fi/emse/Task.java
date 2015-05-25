package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class Task extends JComponent {

	private static final long serialVersionUID = 5222742123553851242L;

	private Part part;

	private boolean completed;

	private Task nextTask;

	private List<Observer> observers = new ArrayList<Observer>();

	public Task(Part part, Task nextTask) {
		this.part = part;
		this.nextTask = nextTask;
	}

	public boolean accept(Part part) {
		if (completed && nextTask != null) {
			return nextTask.accept(part);
		} else {
			if (this.part.getClass().equals(part.getClass())) {
				completed = true;
				notifyTaskCorrect();
				return true;
			} else {
				notifyTaskIncorrect();
				return false;
			}
		}
	}

	private void notifyTaskCorrect() {
		for (Observer observer : observers) {
			if (observer != null) {
				observer.taskCorrect();
			}
		}
	}

	private void notifyTaskIncorrect() {
		for (Observer observer : observers) {
			if (observer != null) {
				observer.taskIncorrect();
			}
		}
	}

	public void paint(Graphics g) {
		if (completed) {
			part.setSize(getSize());
			part.paintComponent(g);
	
			if (nextTask != null) {
				nextTask.setSize(getSize());
				nextTask.paint(g);
			}
		}
	}

	public BufferedImage getImage() {
		return part.getImage();
	}

	public void addObserver(Observer observer) {
		observers .add(observer);
	}

}
