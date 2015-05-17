package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Station extends Component{
	private static final long serialVersionUID = 1L;
	
	protected List<Task> tasks = new ArrayList<Task>();
	
	public void addTaskArray(List<Task> tasks){
		this.tasks = tasks;
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.GREEN);
		
		int borderX = getX() + 10;
		int borderY = getY() + 40;
		
		System.out.println(borderX + "-" + borderY + "-" + getWidth() + "-" + getHeight());
		
		g.drawRect(borderX, borderY, getWidth(), getHeight());
		g.drawString("STATION", borderX, borderY);
	}
}
