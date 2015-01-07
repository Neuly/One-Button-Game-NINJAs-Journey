package obng;

import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import processing.core.*;

/**
 * A class to represent a single figure in the game
 */
public class Figure {

	public int x;
	
	public int y;
	
	public PImage figure;
	
	public String type;
	
	public String text_container;
	
	public Figure (PApplet p, int _x, int _y, String path_to_figure, String _type, String _text_container) {
		this.x = _x;
		this.y = _y;
		this.figure = p.loadImage(path_to_figure);
		this.type = _type;
		this.text_container = _text_container;
	}
	
}

