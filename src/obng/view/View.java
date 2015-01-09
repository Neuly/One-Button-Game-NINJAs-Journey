package obng.view;

import java.util.LinkedList;

import obng.datastructures.Figure;
import processing.core.*;

public class View {
	private PApplet painter;
	private int width;
	private int height;
	private PFont font;
	private String PATH_TO_IMAGES;
	private int linecounter;

	/**
	 * a variable with 3 values - 0, show start screen, 1, show game, 2, game
	 * paused
	 */
	public int show_screen;

	public View(PApplet painter, int width, int height, String _path_to_images) {
		this.painter = painter;
		this.width = width;
		this.height = height;
		font = painter.createFont("Comic Sans MS", 16, true);
		painter.size(width, height);
		show_screen = 0;
		PATH_TO_IMAGES = _path_to_images;
		linecounter = 0;
	}

	/**
	 * draws the frame of the chess board and the board itself - without the
	 * players
	 */
	public void draw(LinkedList<Figure> figures) {
		switch (show_screen) {
		case 0:
			show_start_screen();
			break;
		case 2:
			show_pause_screen();
			break;
		default:
			show_game_screen(figures);
			break;
		}
	}

	private void show_game_screen(LinkedList<Figure> figures) {
		Figure current_figure;
		painter.background(255);
		while (!figures.isEmpty()) {
			current_figure = figures.pop();
			// draw the line
			if (current_figure.type.compareTo("line") == 0) {
				painter.line(0, painter.getHeight() - 25, painter.getWidth(),
						painter.getHeight() - 25);

				
				painter.line(0 + (linecounter * 4), height - 25, 5 + (linecounter * 4),
						width - 25);
				if (current_figure.x == 1)
					linecounter++;
				linecounter = linecounter % 5;
			} else
			// draw text if necessary
			if (current_figure.type.compareTo("text") == 0) {

			}
			// draw the corresponding image
			else
				painter.image(current_figure.figure, current_figure.x,
						current_figure.y);
		}

	}

	private void show_pause_screen() {
		painter.fill(255, 255, 255);
		painter.stroke(0, 0, 0);
		painter.rect(0, 0, width, height);
		painter.fill(255, 255, 255);
		painter.textFont(font, 36);
		painter.textAlign(PApplet.CENTER);
		painter.text("paused", width / 2, height / 2);
	}

	private void show_start_screen() {

		// TODO Auto-generated method stub
		PImage start_screen1 = painter.loadImage(PATH_TO_IMAGES
				+ "startscreen2.JPG");

		painter.image(start_screen1, 0, 0, width, height);

	}

	public void write_Text(boolean valid) {

	}

	public boolean game_paused() {
		return show_screen == 2;
	}

	public void write_Start() {

	}

	/**
	 * 
	 */
	public void mousePressed() {
		if (show_screen == 0)
			show_screen++;
		System.out.println(" show screem " + show_screen);
	}
}