package obng.view.datastructures;

import java.util.Set;

import obng.model.datastructures.Counter;
import obng.model.datastructures.MultipleTimer;
import obng.model.datastructures.Timer;
import processing.core.PApplet;

/**
 * Draws the Background all by itself
 * 
 * @author Neuly
 */
public class Background extends DrawingAssistant {

	private MultipleTimer internal_timer;

	private Counter seperation;

	/** Construct the Text Painter */
	public Background(PApplet _painter, int _width, int _heigth) {
		super(_painter, _width, _heigth);
		Timer local_timer_array[] = { new Timer(1), new Timer(25) };
		internal_timer = new MultipleTimer(local_timer_array);
		seperation = new Counter(0);

	}

	/** Draws the background */
	public void draw() {
		setBackground(255);
		resize();
		horizontal_line(height_of_applet() - 25, 0, width_of_applet());

		if (internal_timer.is_it_time_on_clock(0))
			seperation.up();

		for (int i = 0; i < width_of_applet(); i += 25) {
			vertical_line(25 + i - seperation.times(), height_of_applet() - 25,
					height_of_applet() - 0);
		}

		if (internal_timer.is_it_time_on_clock(1))
			seperation.reset();

		vertical_line(width_of_applet() - 40, 10, 50);
		vertical_line(width_of_applet() - 55, 10, 50);

	}

	/** sets the internal timer to false */
	public void paused(boolean status_pause) {
		internal_timer.pause_or_continue(status_pause);
	}
}
