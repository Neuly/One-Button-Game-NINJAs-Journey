package obng.view.datastructures;

import obng.model.datastructures.Counter;
import obng.model.datastructures.Timer;
import processing.core.PApplet;

/**
 * Draws the Background all by itself
 * 
 * @author Neuly
 */
public class Background extends DrawingAssistant {

	private Timer internal_timer;

	private Counter seperation;

	/** Construct the Text Painter */
	public Background(PApplet _painter) {
		super(_painter);
		// reset the line every 10 ticks
		internal_timer = new Timer(10);
		seperation = new Counter(0);
	}

	/** Draws the background */
	public void draw() {

		horizontal_line(height() - 25, 0, width()); // ground line

		if (internal_timer.is_it_time())
			seperation.up();

		vertical_line(25, 25, 0);

	}
}
