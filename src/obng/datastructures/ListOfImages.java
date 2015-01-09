package obng.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PImage;

/**
 * Actually that is a Linked List of different PIMAGES, it should return a new
 * PIMAGE, that needs to act. If theire are more than just one Image, it should
 * go through it, with an Iterator.
 * 
 * @author Neuly
 */
public class ListOfImages extends LinkedList<PImage> {

	private Iterator<PImage> i = this.iterator();

	/** Empty Constructor */
	public ListOfImages() {
		super();
	}

	/**
	 * @return the current image of the actor
	 */
	public PImage next() {
		if (!i.hasNext())
			i = this.iterator();
		return i.next();
	}

}
