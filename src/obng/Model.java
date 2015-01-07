package obng;

import java.util.LinkedList;

import processing.core.*;

public class Model {
	private PApplet painter;
	private String PATH_TO_FILES;
	private boolean show_ninja;
	private boolean attack;
	private boolean jump;
	private Figure jumping_ninja;
	private Figure attacking_ninja;
	private Figure running_ninja_1;
	private Figure running_ninja_2;
	private Figure zombie;
	private boolean show_rock_1_2;
	private Figure rock1;
	private Figure rock2;
	private Figure score;

	public Model(PApplet painter, String path_to_files) {
		this.painter = painter;
		this.PATH_TO_FILES = path_to_files;
		this.attack = false;
		this.jump = false;
		this.show_ninja = false;
		this.show_rock_1_2 = false;
		this.jumping_ninja = new Figure(painter, 25 + 75 + 100, 25 + 88 + 100,
				PATH_TO_FILES + "jump.JPG", "jumoing ninja", "");
		this.attacking_ninja = new Figure(painter, 25 + 75, 25 + 88,
				PATH_TO_FILES + "attack.JPG", "attacking ninja", "");
		this.running_ninja_1 = new Figure(painter, 25 + 75, 25 + 88,
				PATH_TO_FILES + "run_1.JPG", "running ninja I", "");
		this.running_ninja_2 = new Figure(painter, 25 + 75, 25 + 88,
				PATH_TO_FILES + "run_2.JPG", "running ninja II", "");
		this.rock1 = new Figure(painter, 0, 0, PATH_TO_FILES + "rock.JPG",
				"attacking ninja", "");
		this.rock2 = new Figure(painter, 0, 0, PATH_TO_FILES + "rock2.JPG",
				"attacking ninja", "");
		this.zombie = new Figure(painter, 0, 0, PATH_TO_FILES
				+ "zombie_bean.JPG", "attacking ninja", "");
		this.score = new Figure(painter, 0, 0, null, "score", "0");
	}

	/**
	 * returns a list of figures
	 */
	public LinkedList<Figure> figures_on_screen() {
		LinkedList<Figure> figures = new LinkedList<Figure>();
		figures.push(screen_line());
		figures.push(the_ninja("ninja"));
		return figures;
	}

	/** returns a ninja figure, takes care of the automatic movement of the feet */
	private Figure the_ninja(String string) {
		if (jump) {
			return jumping_ninja;
		} else if (attack) {
			return attacking_ninja;
		} else // just move
		{
			show_ninja = !show_ninja;
			if (show_ninja)
				return running_ninja_1;
			else
				return running_ninja_2;
		}

	}

	private Figure get_me_a_at(String element, int x, int y) {
		switch (element) {
		case "rock":
			show_rock_1_2 = !show_rock_1_2;
			if (show_rock_1_2) {
				rock1.set_xy(x, y);
				return rock1;
			}
			else {
				rock2.set_xy(x, y);
				return rock2;
			}
		case "zombie":
			zombie.set_xy(x, y);
			return zombie;
		default:
			break;
		}
		return null;
	}

	private Figure screen_line() {
		return (new Figure(painter, -1, 25, null, "line", ""));
	}

	/** button pressed */
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
