package obng;

import java.util.LinkedList;

import processing.core.*;

public class Model {
	private PApplet painter;
	private int boardSize;
	private int fieldSize;
	private int frameSize;
	
	public Model(PApplet painter, int boardSize, int fieldSize, int frameSize, float tokenRadius) {
		this.painter = painter;
		this.boardSize = boardSize;
		this.fieldSize = fieldSize;
		this.frameSize = frameSize;
	}
	
	/**
	 * returns a list of figures
	 */
	public LinkedList<Figure> figures_on_screen() {
		LinkedList<Figure> figures = new LinkedList<Figure>();
		
		
		return figures;
	}
	
	/** allows the movement of the buttons */
	public void mousePressedEvent() {
		
	}
	
	/** what to do when the mouse is released */
	public boolean mouseReleasedEvent() {

		return true;
	}
	

	/** true if its over the circle */
	private boolean isOverCircle(float x, float y, float diameter) {
		float disX = x - painter.mouseX;
		float disY = y - painter.mouseY;
		return PApplet.sqrt(PApplet.sq(disX) + PApplet.sq(disY)) < diameter / 2;
	}
	
}
