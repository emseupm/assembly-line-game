package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse extends Component {

	private static int INVENTORY_SIZE = 3;
	private static final long serialVersionUID = -4985756162707607745L;
	private ArrayList<Part>  myInventory;
	
	public Warehouse(){		
		this.myInventory = fillInventory();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("WAREHOUSE", padding * 2, padding * 2);
		
		paintPartsInInventory(g);
	}
	
	private void paintPartsInInventory(Graphics g){
		// Paint all Parts stored in my inventory aligned horizontally
		int x = 0;
		int y = 0;
		for (Part p : myInventory){
		//	p.paint(x,y);
			x = x + 10;
		}	
	}

	private ArrayList<Part> fillInventory(){
		
		ArrayList<Part> myInv;
		myInv = new ArrayList<Part>();
		for (int i = 0; i<INVENTORY_SIZE;i++){
		//	myInv.add(Part.generateRandomPart());
		}
		return myInv;
	}
}
