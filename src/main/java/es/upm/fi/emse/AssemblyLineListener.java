package es.upm.fi.emse;

public interface AssemblyLineListener {

	public void firstStationFreed(AssemblyLine assemblyLine);
	public void stationSelected(Station station);

}
