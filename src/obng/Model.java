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
	private int width;
	private int heigth;
	private int show_ninja_counter;
	private LinkedList<Figure> problems;
	private final int game_over_line = 88;
	private int HEIGHT_OF_A_FIGURE;
	private boolean paused;
	private int show_new_enemy_counter;
	private int speed;

	public Model(PApplet painter, String path_to_files, int _width, int _heigth) {
		speed = 5;
		paused = true;
		this.show_ninja_counter = 0;
		this.show_new_enemy_counter = 1;
		this.width = _width;
		this.heigth = _heigth;
		this.HEIGHT_OF_A_FIGURE = heigth - 25;
		this.painter = painter;
		this.PATH_TO_FILES = path_to_files;
		this.attack = false;
		this.jump = false;
		this.show_ninja = false;
		this.show_rock_1_2 = false;
		this.jumping_ninja = new Figure(painter, 88, HEIGHT_OF_A_FIGURE - 100,
				PATH_TO_FILES + "jump.JPG", "jumoing ninja", "");
		this.attacking_ninja = new Figure(painter, 88,
				HEIGHT_OF_A_FIGURE - 175, PATH_TO_FILES + "attack.JPG",
				"attacking ninja", "");
		this.running_ninja_1 = new Figure(painter, 88,
				HEIGHT_OF_A_FIGURE - 175, PATH_TO_FILES + "run_1.JPG",
				"running ninja I", "");
		this.running_ninja_2 = new Figure(painter, 88,
				HEIGHT_OF_A_FIGURE - 175, PATH_TO_FILES + "run_2.JPG",
				"running ninja II", "");
		this.rock1 = new Figure(painter, 0, 0, PATH_TO_FILES + "rock.JPG",
				"rock 2", "");
		this.rock2 = new Figure(painter, 0, 0, PATH_TO_FILES + "rock2.JPG",
				"rock 1", "");
		this.zombie = new Figure(painter, 0, 0, PATH_TO_FILES
				+ "zombie_bean.JPG", "zombie", "");
		this.score = new Figure(painter, 25, 25, null, "score", "0");
		this.problems = new LinkedList<Figure>();
	}

	/**
	 * returns a list of figures
	 */
	public LinkedList<Figure> figures_on_screen() {
		LinkedList<Figure> figures = new LinkedList<Figure>();
		figures.push(screen_line());
		figures.push(the_ninja("ninja"));
		enemies_and_problems();
		for (int i = 0; i < problems.size(); i++)
			figures.add(problems.get(i));

		return figures;
	}

	private LinkedList<Figure> enemies_and_problems() {
		if (paused)
			return problems;

		// if it is smaller than three
		if (problems.size() < 3) {

			if (problems.size() >= 1) {
				
				show_new_enemy_counter++;
				if (show_new_enemy_counter % speed != 0) {
					return problems;
				}
				show_new_enemy_counter = 0;
				
				// move everyone about 10
				for (int i = 0; i < problems.size(); i++) {
					problems.get(i).reduce_x_by(10);
				}


				// add new enemy or problem
				if (show_new_enemy_counter % (int) Math.abs(speed /10)) {
					int which_one = (int) Math.abs(Math.random() * 3);
					switch (which_one) {
					case 0:
						Figure another_zombie_bean = new Figure(zombie);
						another_zombie_bean.set_xy(width, HEIGHT_OF_A_FIGURE - 175);
						problems.add(another_zombie_bean);
						break;
					case 1:
						Figure another_rock;
						if (show_rock_1_2)
							another_rock = new Figure(rock1);
						else
							another_rock = new Figure(rock2);
						another_rock.set_xy(width,HEIGHT_OF_A_FIGURE - 100);
						problems.add(another_rock);
						break;
					default:
						break;
					}
				}

			} else {
				Figure another_zombie_bean = new Figure(zombie);
				another_zombie_bean.set_xy(width, HEIGHT_OF_A_FIGURE - 175);
				problems.push(another_zombie_bean);
			}

		}
		return problems;
	}

	/** returns a ninja figure, takes care of the automatic movement of the feet */
	private Figure the_ninja(String string) {

		if (jump && !paused) {
			return jumping_ninja;
		} else if (attack && !paused) {
			return attacking_ninja;
		} else // just move
		{
			if (show_ninja_counter % 10 == 0)
				show_ninja = !show_ninja;
			show_ninja_counter++;
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
				rock1.set_xy(heigth - x, y);
				return rock1;
			} else {
				rock2.set_xy(heigth - x, y);
				return rock2;
			}
		case "zombie":
			zombie.set_xy(heigth - x, y);
			return zombie;
		default:
			return new Figure(painter, x, y, null, "text", element);
		}
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

	/** stes paused to p */
	public void paused(boolean p) {
		paused = p;
	}

}
