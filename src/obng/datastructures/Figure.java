package obng.datastructures;

import processing.core.*;

/**
 * A class to represent a single figure in the game
 * 
 * Consisting of the following three other classes: - Actor - Text - Coordinate
 * 
 * @author Neuly
 */
public class Figure extends Actor {

	/** A text container object for output text */
	public Text text_container;

	/**
	 * Constructor for the Figure
	 * 
	 * @param _figure
	 *            - a visual PImage Processing representation of an actor
	 * @param _x
	 *            - the x position
	 * @param _y
	 *            - the y position
	 * @param _type
	 *            - the type of object
	 * @param _text_line
	 *            - the text line of the text_container
	 * @param _text_size
	 *            - the text size of the text_container
	 */
	public Figure(PImage _figure, int _x, int _y, String _type,
			String _text_line, int _text_size) {
		super(_figure, _type, _x, _y);

		this.text_container = new Text(_text_line, _text_size);
	}

	/** copies a given Figure from the given Figure Object */
	public Figure(Figure to_copy_from) {
		super(to_copy_from.act(), to_copy_from.what_type_of_actor(),
				to_copy_from.move_in_x_axis(0), to_copy_from.move_in_y_axis(0));
		Text local_text_copy = to_copy_from.text_container;
		this.text_container = new Text(local_text_copy);
	}

}
