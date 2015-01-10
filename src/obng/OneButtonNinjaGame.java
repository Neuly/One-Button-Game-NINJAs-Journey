package obng;

import obng.model.Model;
import obng.view.View;
import obng.view.datastructures.GameStatus;
import processing.core.*;

/**
 * This is the main class of the One Button Game, Ninja Beans Journey
 * 
 * @author Neuly
 */
public class OneButtonNinjaGame extends PApplet {
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1000;
	private final int HEIGHT = 500;

	private Model model;
	private View view;

	/** constructor */
	public void setup() {
		String PATH_TO_IMAGES = System.getProperty("user.dir")
				+ System.getProperty("file.separator");
		GameStatus gs = new GameStatus();
		view = new View(this, WIDTH, HEIGHT, PATH_TO_IMAGES, gs);
		model = new Model(this, PATH_TO_IMAGES, WIDTH, HEIGHT, gs);
	}

	/** draws everything */
	public void draw() {
		view.draw(model.figures_on_screen(1, false, false));
		
		if (mousePressed) {
			// view.mousePressed();
			// model.pause_or_continue(view.game_paused());
		}
	}

	/** Starts the applet */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "obng.OneButtonNinjaGame" });
	}

}
