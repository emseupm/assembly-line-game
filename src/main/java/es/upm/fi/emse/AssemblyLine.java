package es.upm.fi.emse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AssemblyLine extends Component {

	private static final long serialVersionUID = -7209808105752155582L;

	protected List<Station> stations;
	protected List<RecipeLoader> recipeLoaders;
	protected int totalStations;
	
	public AssemblyLine(){
		
		stations = new ArrayList<Station>();
		totalStations = 5;
		
		setupStations();
	}
	
	private void setupStations(){
		for(int i=0; i<totalStations; i++){
			Station station = new Station();
			
			station.setBounds(0,30,100,100);
			stations.add(station);
			
			System.out.println(i);
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);

		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("ASSEMBLY LINE", padding * 2, padding * 2);
	}
}
