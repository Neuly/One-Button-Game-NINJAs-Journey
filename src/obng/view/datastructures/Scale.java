package obng.view.datastructures;

/**
 * Represents the scale of an Object
 * 
 * @author Neuly
 */
public class Scale {

	private int x;

	private int y;

	public Scale(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	public int width_of_applet() {
		return x;
	}

	public int height_of_applet() {
		return y;
	}

}
