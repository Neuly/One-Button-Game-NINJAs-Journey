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

}
