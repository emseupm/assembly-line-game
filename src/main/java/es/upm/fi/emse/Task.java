package es.upm.fi.emse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Task extends JComponent {

	private static final long serialVersionUID = 5222742123553851242L;

	private Part part;

	private boolean completed;

	private Task nextTask;
	
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
				return true;
			} else {
				return false;
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

}
