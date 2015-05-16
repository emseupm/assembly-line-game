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
	//protected int totalStations;
	
	
	public AssemblyLine(){
		stations = new ArrayList<Station>();
		setupStations();

		//totalStations = 5;
	}
	
	public void setupStations(){
		int totalStations = 10;
		//int totalStations = stations.size();

		int padding = 10;
		
		int stationWidth = getWidth() / totalStations;
		for(int i = 0; i < totalStations; i++){
			Station station = new Station();
			int borderX = getX() + padding;
			int borderY = getY() + padding;
			station.setBounds(borderX + (i * stationWidth), borderY, stationWidth, getHeight());
			stations.add(station);
		}
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.BLUE);
		int padding = 10;
		g.drawRect(padding, padding, getWidth() - (padding * 2), getHeight() - (padding * 2));
		g.drawString("ASSEMBLY LINE", padding * 2, padding * 2);
		
		for(int i = 0; i < stations.size(); i++){
			stations.get(i).paint(g);
		}
	}
}
