package obng.view.datastructures;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * The Drawing Assistant - A Wrapper for the font and the papplet painter.
 * 
 * @author Neuly
 */
public class DrawingAssistant extends Scale {

	private PFont font;
	private PApplet painter;

	/** Construct the Drawing Assistant */
	public DrawingAssistant(PApplet _painter, int _width, int _heigth) {
		super(_width, _heigth);
		this.painter = _painter;
		this.painter.setSize(_width, _heigth);
	}

	/** draws a horizontal line from to at height_of_line */
	public void horizontal_line(float heigth_of_line, float from, float to) {
		painter.line(from, heigth_of_line, to, heigth_of_line);
	}

	/** draws a vertical line from to at width_of_line */
	public void vertical_line(float width_of_line, float from, float to) {
		painter.line(width_of_line, from, width_of_line, to);
	}

	/** sets the background to color c */
	public void setBackground(int c) {
		painter.background(c);
	}

	/** resizes the object with every draw action */
	public void resize() {
		painter.setSize(width_of_applet(), heigth_of_applet());
		painter.setLocation(50, 50);
	}

}
