package obng.model;

import obng.model.datastructures.Actor;
import obng.model.datastructures.ListOfImages;
import obng.model.datastructures.Position_On_Screen;
import obng.model.datastructures.Type_of_actor;
import processing.core.PApplet;

/**
 * The Ninja Class, takes care of different thinks like Score of the player,
 * whenever it loses, whenever it hits something
 * 
 * @author Neuly
 */
public class TheNinja extends Actor {

	/** the actor for the jumping ninja */
	private Actor jumping_ninja;

	/** the actor for the attacking ninja */
	private Actor attacking_ninja;

	/**
	 * The Ninja Constructor - actuall an actor, but with some additions
	 */
	public TheNinja(String _path_to_images, Type_of_actor _type_of_actor,
			int x_coordinate, int y_coordinate, PApplet p) {
		super(new ListOfImages(_path_to_images, "runxxx", p), _type_of_actor,
				x_coordinate, y_coordinate);
		jumping_ninja = new Actor(
				new ListOfImages(_path_to_images, "jumpxx", p),
				new Type_of_actor("Jumping Ninja", 1), x_coordinate,
				y_coordinate + 200); // he jumps
		attacking_ninja = new Actor(new ListOfImages(_path_to_images, "attack",
				p), new Type_of_actor("Jumping Ninja", 1), x_coordinate,
				y_coordinate);

	}

	/**
	 * according to what has happened, return a corresponding element like the
	 * jumping ninja move
	 * 
	 * @param mouse_once_pressed
	 * @param mouse_longer_pressed
	 */
	public Actor next_actor(boolean mouse_once_pressed,
			boolean mouse_longer_pressed) {
		// so jump
		if (mouse_longer_pressed)
			return jumping_ninja;
		// attack
		if (mouse_once_pressed)
			return attacking_ninja;
		// just run
		return this;

	}

}
