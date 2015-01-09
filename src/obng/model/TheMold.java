package obng.model;

import java.util.LinkedList;

import obng.datastructures.Figure;
import obng.datastructures.Timer;
import processing.core.PApplet;

/**
 * 
 * This class actually represents the mold, that attacks the beans in the can.
 * It takes care of all the different actors in the scene - beside the ninja
 * 
 * @author Neuly
 */
public class TheMold extends Agency {

	/** the list of figures used by the mold */
	private LinkedList<Figure> list_of_figures;

	/** Counter */
	private Timer time_for_new_enemy;

	/**
	 * Constructor for TheMold
	 * 
	 * @param path_to_enemies - the path to the images of the enemies
	 * @param painter - needed for reading the file
	 * @param spwan_point_x - spawn point of the enemies, x value
	 * @param spwan_point_y - spwan point of the enemies, y value
	 */
	public TheMold(String path_to_enemies, PApplet painter, int spwan_point_x,
			int spwan_point_y, int timing) {
		super(path_to_enemies, painter, spwan_point_x, spwan_point_y);
		list_of_figures = new LinkedList<Figure>();
		time_for_new_enemy = new Timer(timing);
	}

	/**
	 * returns the acting enemies
	 * 
	 * wohooo, a getter - not in that kind it is meant by the Object
	 * Calisthenics the mold should get moldier ;)
	 * 
	 * @return LinkedList<Figure>
	 */
	public LinkedList<Figure> get_moldier() {
		if (!time_for_new_enemy.is_it_time() || list_of_figures.size() >= 3)
			return list_of_figures;

		if (list_of_figures.isEmpty()) {
			list_of_figures.add(getRandomEnemy());
			return list_of_figures;
		}

		for (Figure local_figure : list_of_figures)
			local_figure.move_in_x_axis(-5);

		return list_of_figures;
	}
}
