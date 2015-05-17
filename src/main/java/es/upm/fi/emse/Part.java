package es.upm.fi.emse;

import java.awt.Component;
import java.awt.Color;

import java.util.Random;

public class Part extends Component {
	
	private static final int numPartTypes = 4;

	protected Color color; 
	
	protected int Size;

	public Part() {
		Size = 1;
	}
	
	public void paint() {
		
	}
	
	public static Part generateRandomTyePart(){
				
		Part p = null;		
		int i = randInt(0,numPartTypes-1);			
		
		switch (i) {
	        case 0:  p = new Coffee();
	                 break;
	        case 1:  p = new Cookie();
	                 break;
	        case 2:  p = new Meatball();
	                 break;
	        case 3:  p = new Lettuce();
            break;
		}		
		
		return p;		
	}
	
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	private static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}