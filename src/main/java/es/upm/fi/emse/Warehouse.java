package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

public class Warehouse extends Component {

	private static int WAREHOUSE_SIZE = 4;
	private static final long serialVersionUID = -4985756162707607745L;
	private ArrayList<Part>  myWarehouse;
	protected int padding = 25;
	
	public Warehouse(){		
		this.myWarehouse = fillWarehouse();
		//this.myWarehouse = fillWarehouseRandomly();
	}

	// Paint the Warehouse box
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("WAREHOUSE", padding * 2, padding * 2);
		
		paintPartsInWarehouse(g);
	}
	
	// Paint all Parts stored in my warehouse aligned horizontally
	private void paintPartsInWarehouse(Graphics g){
		
		int i = 0;
		int partWidth = (getWidth() - padding * 2) / WAREHOUSE_SIZE;
		for (Part p : myWarehouse){		
			p.setBounds(padding + i * (partWidth), padding, partWidth, getHeight() - padding * 2);
			p.paint(g);
			i++;
		}	
	}

	// Fills warehouse with Random Parts
	private ArrayList<Part> fillWarehouseRandomly(){
		
		ArrayList<Part> myW = new ArrayList<Part>();
		
		for (int i = 0; i<WAREHOUSE_SIZE;i++){
			myW.add(Part.generateRandomTyePart());
		}

		return myW;
	}
	
	// Fills Warehouse with selected Parts
	private ArrayList<Part> fillWarehouse(){
		
		ArrayList<Part> myW = new ArrayList<Part>();

		myW.add(new Lettuce());
		myW.add(new Meatball());
		myW.add(new Cookie());
		myW.add(new Coffee());
		
		return myW;
	}
}
