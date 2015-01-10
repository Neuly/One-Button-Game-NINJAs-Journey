package obng.view.datastructures;

import obng.model.datastructures.Counter;
import obng.model.datastructures.Timer;
import processing.core.PApplet;

/**
 * Takes care about the different Mouse actions, like pressed in a specified
 * region or something
 * 
 * @author Neuly
 */
public class Mouse extends Scale {

	private PApplet painter;

	private Counter time_pressed;

	public Mouse(PApplet _painter, int _width, int _height) {
		super(_width, _height);
		painter = _painter;
		time_pressed = new Counter(0);
	}

	/** true if pause occures */
	public boolean mouse_sets_pause() {
		painter.setSize(width_of_applet(), height_of_applet());
		float disX = painter.mouseX - painter.mouseX;
		float disY = painter.mouseX - painter.mouseY;
		return (PApplet.sqrt(PApplet.sq(disX) + PApplet.sq(disY)) < 50 / 2)
				&& painter.mousePressed;
	}

	/**
	 * counts the internal time_pressed counter up everytime the mouse gets
	 * pressed
	 */
	public void mouse_pressed() {
		if (painter.mousePressed)
			time_pressed.up();
	}

	/** returns true, when the mouse is pressed longer then a second */
	public boolean mouse_longer_pressed() {
		int local_var = time_pressed.times();
		time_pressed.reset();
		return local_var > 50;
	}

}
