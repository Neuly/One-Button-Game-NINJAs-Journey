package obng.model;

import java.util.LinkedList;

import obng.model.datastructures.Actor;
import obng.model.datastructures.Figure;
import obng.model.datastructures.Type_of_actor;
import obng.view.datastructures.GameStatus;
import processing.core.*;

/**
 * The Model of the One Button Ninja
 * 
 * @author Neuly
 */
public class Model extends TheMold {

	private TheNinja bean;

	private GameStatus status;
	
	public Model(PApplet painter, String _path_to_files, int _width, int _heigth, GameStatus _gs) {
		super(_path_to_files + "images" + System.getProperty("file.separator"),
				painter, _width, _heigth - 200, 200);
		bean = new TheNinja(_path_to_files + "ninja"
				+ System.getProperty("file.separator"), new Type_of_actor(
				"Ninja running", 3), 100, _heigth - 200, painter);
		status = _gs;
	}

	/**
	 * returns a list of figures
	 * 
	 * @param whichscreen - 0 it is the startscreen, 1 shows the game screen, 2
	 * the pause screen
	 */
	public LinkedList<Actor> figures_on_screen(int whichscreen,
			boolean mouse_once_pressed, boolean mouse_longer_pressed) {	
		LinkedList<Actor> figures = new LinkedList<Actor>();
		if (status.gamespaused())
			return figures;

		figures.add(new Actor(bean.next_actor(mouse_once_pressed,
				mouse_longer_pressed)));
		figures.addAll(get_moldier());

		return figures;
	}

}
