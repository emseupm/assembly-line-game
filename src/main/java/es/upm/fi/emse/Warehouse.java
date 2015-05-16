package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public class Warehouse extends Component {

	private static int WAREHOUSE_SIZE = 3;
	private static final long serialVersionUID = -4985756162707607745L;
	private ArrayList<Part>  myWarehouse;
	
	public Warehouse(){		
		this.myWarehouse = fillWarehouse();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("WAREHOUSE", padding * 2, padding * 2);
		
		paintPartsInWarehouse(g);
	}
	
	private void paintPartsInWarehouse(Graphics g){
		// Paint all Parts stored in my warehouse aligned horizontally
		int x = 0;
		int y = 0;
		for (Part p : myWarehouse){
		//	p.paint(x,y);
			x = x + 10;
		}	
	}

	private ArrayList<Part> fillWarehouse(){
		
		ArrayList<Part> myW;
		myW = new ArrayList<Part>();
		for (int i = 0; i<WAREHOUSE_SIZE;i++){
		//	myW.add(Part.generateRandomPart());
		}
		return myW;
	}
}
