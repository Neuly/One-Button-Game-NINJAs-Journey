package obng.model.datastructures;

import processing.core.PImage;

/**
 * A representation of the actor in the current scene represented by the PImage
 * of the core library of processing. It also stores the type of actor.
 * 
 * @author Neuly
 */
public class Actor extends Coordinate {

	private ListOfImages representation;

	private Type_of_actor type;

	/**
	 * Constructor for an Actor
	 * 
	 * @param _figure - a visual PImage Processing representation of an actor
	 * @param _x - the x position
	 * @param _y - the y position
	 * @param _type - the type of object coordinate on the y axis on the actor
	 * @param y_coordinate coordinate on the y axis of the actor
	 */
	public Actor(ListOfImages _figure, Type_of_actor _type_of_actor,
			int x_coordinate, int y_coordinate) {
		super(x_coordinate, y_coordinate);

		representation = _figure;
		type = _type_of_actor;

	}

	/** A Constructor to clone yourself */
	public Actor(Actor _to_copy) {
		super(_to_copy.the_values());
		this.representation = _to_copy.all_images();
		this.type = _to_copy.what_type_of_actor();
	}

	/** The visual representation of the current actor needs to */
	public PImage act() {
		return representation.next();
	}

	/** returns what kind of actor this object is */
	public Type_of_actor what_type_of_actor() {
		return type;
	}

	/** returns the list of all images */
	public ListOfImages all_images() {
		return representation;
	}

}
