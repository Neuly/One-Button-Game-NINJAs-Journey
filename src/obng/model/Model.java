package obng.model;

import java.util.LinkedList;

import obng.model.datastructures.Actor;
import obng.model.datastructures.Figure;
import obng.model.datastructures.Type_of_actor;
import processing.core.*;

/**
 * The Model of the One Button Ninja
 * 
 * @author Neuly
 */
public class Model extends TheMold {

	private TheNinja bean;

	public Model(PApplet painter, String _path_to_files, int _width, int _heigth) {
		super(_path_to_files, painter, _width, 88 + 25, 200);
		bean = new TheNinja(_path_to_files, new Type_of_actor("Ninja running",
				3), 100, 88 + 25, painter);
	}

	/**
	 * returns a list of figures
	 * 
	 * @param whichscreen - 0 it is the startscreen, 1 gamin
	 */
	public LinkedList<Actor> figures_on_screen(int whichscreen,
			boolean mouse_once_pressed, boolean mouse_longer_pressed) {
		LinkedList<Actor> figures = new LinkedList<Actor>();

		figures.add(new Actor(bean.next_actor(mouse_once_pressed,
				mouse_longer_pressed)));
		figures.addAll(get_moldier());

		return figures;
	}

}
