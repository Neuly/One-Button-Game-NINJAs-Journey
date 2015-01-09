package obng.view.datastructures;

import obng.model.datastructures.Timer;
import processing.core.PApplet;

/**
 * Draws the Background all by itself
 * 
 * @author Neuly
 */
public class Background extends DrawingAssistant {

	private Timer internal_timer;

	/** Construct the Text Painter */
	public Background(PApplet _painter) {
		super(_painter);
		// reset the line every 10 ticks
		internal_timer = new Timer(10);
	}

	
	public void draw() {
		// TODO Auto-generated method stub

	}
}
