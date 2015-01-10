package obng.view.datastructures;

import processing.core.PApplet;
import processing.core.PFont;

/**
 * The text painter - paints some text at a given point to the screen
 * 
 * @author Neuly
 */
public class TextPainter extends DrawingAssistant {

	/** Construct the Text Painter */
	public TextPainter(PApplet _painter, int _width, int _heigth) {
		super(_painter, _width, _heigth);
	}

	/** writes a text to the applet */
	public void writeText(String string, int i, int j) {
		text(string, i, j);
	}

}
