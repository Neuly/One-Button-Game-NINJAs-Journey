package obng.view.datastructures;

import java.util.LinkedList;

import obng.model.datastructures.Actor;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * One Screen at a time
 * 
 * @author Neuly
 */
public class Screen extends ImageDrawer {

	private Background back;
	private TextPainter txtPai;

	public Screen(PApplet _painter, int _width, int _height) {
		super(_painter, _width, _height);
		back = new Background(_painter, _width, _height);
		txtPai = new TextPainter(_painter, _width, _height);
	}

	/**
	 * draws a given Screen represented by a list of actors
	 */
	public void draw_screen(LinkedList<Actor> list_of_actors) {
		back.draw();
		for (final Actor anActor : list_of_actors) {
			drawAt(anActor.act(), anActor.move_in_x_axis(0),
					anActor.move_in_y_axis(0));
		}
	}

	/**
	 * pauses the game by using a white screen with a picture displayed
	 */
	public void draw_paused(Actor pause_screen) {
		resize();
		// write pause
		txtPai.writeText("Pause", 400, 100);
	}

	/**
	 * pauses the game by using a white screen with a picture displayed
	 */
	public void draw_start_screen(String path_to_screens) {
		resize();
		drawAt(loadImage(path_to_screens + "screens"
				+ System.getProperty("file.separator") + "start.JPG"), 0, 0, width_of_applet(), height_of_applet());
	}

}
