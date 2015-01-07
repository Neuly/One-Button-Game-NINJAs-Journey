package obng;
import processing.core.*;


/**
 * @author Phil
 *
 */
public class OneButtonNinjaGame extends PApplet {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_SIZE = 50;
	private static final int FIELD_SIZE = 50;
	private static final float TOKEN_RADIUS = FIELD_SIZE/2;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final int BOARD_SIZE = 8;

	private Model model;
	private View view;
	
	/** constructor */
	public void setup() {
		String PATH_TO_IMAGES = System.getProperty("user.dir") + System.getProperty("file.separator") + "images" + System.getProperty("file.separator");
		model = new Model(this, BOARD_SIZE, FIELD_SIZE, FRAME_SIZE, TOKEN_RADIUS);
		view = new View(this, WIDTH, HEIGHT, FIELD_SIZE, FRAME_SIZE, TOKEN_RADIUS,PATH_TO_IMAGES);
//		view.writeTurn(model.getTurn());
	}
	
	/** draws everything */
	public void draw() {
		view.draw(null);
//		view.draw_tokens(model.getBoard().getTokens());
//		
//		if(mousePressed) {
//			model.mousePressedEvent();
//			if(view.isReset())
//				model.resetGame();
//		}
	}
	
	public void mouseReleased() {
//		boolean valid = model.mouseReleasedEvent();
//		view.writeValid(valid);
//		view.writeTurn(model.getTurn());
//		view.writeWin(model.checkWinState());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(new String[] { "--present", "obng.OneButtonNinjaGame" });
	}

}

