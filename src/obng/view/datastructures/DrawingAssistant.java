package obng.view.datastructures;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * The Drawing Assistant - A Wrapper for the font and the papplet painter.
 * 
 * @author Neuly
 */
public class DrawingAssistant {

	private PFont font;
	private PApplet painter;

	/** Construct the Drawing Assistant */
	public DrawingAssistant(PApplet _painter) {
		this.painter = _painter;
	}

	/** returns the hight of the PApplet */
	public float height() {
		return painter.getHeight();
	}

	/** returns the width of the PApplet */
	public float width() {
		return painter.getWidth();
	}

	/** draws a horizontal line from to at height_of_line */
	public void horizontal_line(float heigth_of_line, float from, float to) {
		painter.line(from, heigth_of_line, to, heigth_of_line);
	}

	/** draws a vertical line from to at width_of_line */
	public void vertical_line(float width_of_line, float from, float to) {
		painter.line(width_of_line, from, width_of_line, to);
	}

}
