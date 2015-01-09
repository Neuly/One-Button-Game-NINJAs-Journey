package obng.model;

import obng.datastructures.Actor;
import obng.datastructures.ListOfImages;
import obng.datastructures.Type_of_actor;

/**
 * The Ninja Class, takes care of different thinks like Score of the player,
 * whenever it loses, whenever it hits something
 * 
 * @author Neuly
 */
public class TheNinja extends Actor {

	/**
	 * The Ninja Constructor - actuall an actor, but with some additions
	 * 
	 * @param _figure
	 * @param _type_of_actor
	 * @param x_coordinate
	 * @param y_coordinate
	 */
	public TheNinja(ListOfImages _figure, Type_of_actor _type_of_actor,
			int x_coordinate, int y_coordinate) {
		super(_figure, _type_of_actor, x_coordinate, y_coordinate);
	}

}
