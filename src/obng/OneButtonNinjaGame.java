package obng;

import processing.core.*;

/**
 * @author Phil
 * 
 */
public class OneButtonNinjaGame extends PApplet {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 750;
	private static final int HEIGHT = 750;

	private Model model;
	private View view;

	/** constructor */
	public void setup() {
		String PATH_TO_IMAGES = System.getProperty("user.dir")
				+ System.getProperty("file.separator") + "images"
				+ System.getProperty("file.separator");
		view = new View(this, WIDTH, HEIGHT, PATH_TO_IMAGES);
		model = new Model(this,PATH_TO_IMAGES);
	}

	private boolean was_not_pressed_before;

	/** draws everything */
	public void draw() {
		view.draw(model.figures_on_screen());

		if (mousePressed) {
			view.mousePressed();
			model.mousePressedEvent();
		}
	}

	public void mouseReleased() {
		// boolean valid = model.mouseReleasedEvent();
		// view.writeValid(valid);
		// view.writeTurn(model.getTurn());
		// view.writeWin(model.checkWinState());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(new String[] { "--present", "obng.OneButtonNinjaGame" });
	}

}
