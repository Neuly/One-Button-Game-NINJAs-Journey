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

	public Figure(PApplet p, int _x, int _y, String path_to_figure,
			String _type, String _text_container) {
		this.x = _x;
		this.y = _y;
		if (path_to_figure != null)
			this.figure = p.loadImage(path_to_figure);
		this.type = _type;
		this.text_container = _text_container;
	}

	public void set_xy(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}

	// copies a figure
	public Figure(Figure to_copy_from) {
		this.x = to_copy_from.x;
		this.y = to_copy_from.y;
		this.figure = to_copy_from.figure;
		this.type = to_copy_from.type;
		this.text_container = to_copy_from.text_container;
	}

	public void reduce_x_by(int s) {
		this.x = this.x - s;
		System.out.println(type + " reduced to " + x);
	}

	public void reduce_y_by(int s) {
		this.y = this.y - s;
	}

}
