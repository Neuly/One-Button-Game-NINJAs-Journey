package obng;

import obng.model.Model;
import obng.view.View;
import processing.core.*;

/**
 * This is the main class of the One Button Game, Ninja Beans Journey
 * 
 * @author Neuly
 */
public class OneButtonNinjaGame extends PApplet {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 500;

	private Model model;
	private View view;

	/** constructor */
	public void setup() {
		String PATH_TO_IMAGES = System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "images"
				+ System.getProperty("file.separator");
		view = new View(this, WIDTH, HEIGHT);
		model = new Model(this, PATH_TO_IMAGES, WIDTH, HEIGHT);
	}

	/** draws everything */
	public void draw() {
		view.draw(model.figures_on_screen(1, false, false));

		if (mousePressed) {
			view.mousePressed();
			model.pause_or_continue(view.game_paused());
		}
	}

	/** Starts the applet */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(new String[] { "--present", "obng.OneButtonNinjaGame" });
	}

}
