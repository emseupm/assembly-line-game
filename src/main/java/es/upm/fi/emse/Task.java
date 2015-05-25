package es.upm.fi.emse;

public class Task {
	
	private Part part;
	
	public void setPart(Part part) {
		this.part = part;
	}
	
	public Part getPart() {
		return part;
	}

	public void draw() {
		//TODO implement method
	}

	public boolean accept(Part part) {
		// TODO perform validation
		return this.part.equals(part);
	}
}
