package obng.model.datastructures;

import processing.core.PImage;

/**
 * A Container for the final two parts for the view - the Coordinate and the
 * PIMAGE
 * 
 * @author Neuly
 */
public class Position_On_Screen extends Coordinate {

	private PImage img;

	/**
	 * Constructor for the final on screen elements
	 */
	public Position_On_Screen(PImage _img, Coordinate _the_values) {
		super(_the_values);
		img = _img;
	}

	/** returns the PImage */
	public PImage element_to_show() {
		return img;
	}

}
