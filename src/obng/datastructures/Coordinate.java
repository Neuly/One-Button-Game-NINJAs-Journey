package obng.datastructures;

/**
 * A class, Coordinates, that wraps around the coordinates x and y
 * 
 * @author Neuly
 */
public class Coordinate {
	
	private int x;
	
	private int y;
	
	/** constructor - sets the x and y value with the given parameters */
	public Coordinate (int x,  int y){
		this.x = x;
		this.y = y;
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
	
}

