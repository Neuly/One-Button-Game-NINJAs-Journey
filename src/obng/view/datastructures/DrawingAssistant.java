package obng.view.datastructures;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

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
		painter.setSize(width_of_applet(), height_of_applet());
		painter.setLocation(50, 50);
	}

	/** draws a given PImage at a specified postioion */
	public void drawAt(PImage act, int x_coordinateint, int y_coordinate) {
		painter.image(act, x_coordinateint, y_coordinate);
	}
	
	/** draws a given PImage at a specified postioion */
	public void drawAt(PImage act, int x_coordinateint, int y_coordinate, int width, int height) {
		painter.image(act, x_coordinateint, y_coordinate, width, height);
	}

	/** paints some text to the papplet */
	public void text(String string, int i, int j) {
		painter.text(string, i, j);
	}

	/** reads an Image into the painter */
	public PImage loadImage(String filename) {
		return painter.loadImage(filename);
	}
}
