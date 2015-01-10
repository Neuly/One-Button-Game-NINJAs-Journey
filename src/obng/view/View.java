package obng.view;

import java.util.LinkedList;

import javax.imageio.ImageWriter;

import obng.model.datastructures.Actor;
import obng.model.datastructures.Figure;
import obng.model.datastructures.MultipleTimer;
import obng.model.datastructures.Timer;
import obng.view.datastructures.Background;
import obng.view.datastructures.GameStatus;
import obng.view.datastructures.ImageDrawer;
import obng.view.datastructures.Mouse;
import obng.view.datastructures.Screen;
import obng.view.datastructures.TextPainter;
import processing.core.*;

/**
 * The View Class, sorry, here I needed to use more than one Object
 * 
 * @author Neuly
 */
public class View extends Mouse {

	private Screen game;

	private GameStatus status;

	private String path_to_screens;

	/** Construct the view class 
	 * @param _gs */
	public View(PApplet _painter, int _width, int _height,String _path_to_screens, GameStatus _gs) {
		super(_painter, _width, _height);
		game = new Screen(_painter, _width, _height);
		status = _gs;
		path_to_screens = _path_to_screens;
	}

	/** draws the game screen */
	public void draw(LinkedList<Actor> list_of_actors) {
		if (status.startscreen()) {
			game.draw_start_screen(path_to_screens);
			return;
		}
		if (status.gamespaused()) {
			game.draw_paused(null);
			return;
		}
		mouse_pressed();
		if (mouse_sets_pause()) {
			game.draw_paused(list_of_actors.pop());
			return;
		}
		game.draw_screen(list_of_actors);
	}

}
