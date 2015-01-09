package obng.model.datastructures;

/**
 * A class, Coordinates, that wraps around the coordinates x and y
 * 
 * @author Neuly
 */
public class Coordinate {

	private int x;

	private int y;

	/** constructor - sets the x and y value with the given parameters */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** Constructor for cloning the object from another one */
	public Coordinate(Coordinate _to_copy) {
		this.x = _to_copy.move_in_x_axis(0);
		this.y = _to_copy.move_in_y_axis(0);
	}

	/** changes the x coordinate value and returns it afterwards */
	public int move_in_x_axis(int about_pixels) {
		this.x += about_pixels;
		return x;
	}

	/** changes the y coordinate value and returns it afterwards */
	public int move_in_y_axis(int about_pixels) {
		this.y -= about_pixels;
		return y;
	}

	/** returns the whole Object */
	public Coordinate the_values() {
		return new Coordinate(x, y);
	}

}
