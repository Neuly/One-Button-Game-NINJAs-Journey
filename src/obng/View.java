package obng;

import java.util.LinkedList;

import processing.core.*;

public class View {
	private PApplet painter;
	private int width; 
	private int height;
	private PFont font;
	private String PATH_TO_IMAGES;
	
	/** a variable with 3 values - 0, show start screen, 1, show game, 2, game paused */
	private int show_screen;
	
	public View(PApplet painter, int width, int height, int fieldSize, int frameSize, float tokenRadius, String _path_to_images) {
		this.painter = painter;
		this.width = width;
		this.height = height;
		font = painter.createFont("Comic Sans MS", 16, true); 
		painter.size(width, height);
		
		show_screen = 0;
		PATH_TO_IMAGES = _path_to_images;
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
		// TODO Auto-generated method stub
		
	}

	private void show_pause_screen() {
		// TODO Auto-generated method stub
		
	}

	private void show_start_screen() {
		// TODO Auto-generated method stub
		PImage start_screen1 = painter.loadImage(PATH_TO_IMAGES + "startscreen.JPG");
		PImage start_screen2 = painter.loadImage(PATH_TO_IMAGES + "startscreen2.JPG");
		int start_second = painter.second();
		System.out.println("ptrinting start");
		
		painter.image(start_screen1,0,0,30,30);
		// sleep for 6 seconds
		while(painter.second() < (start_second + 6) % 60) {
		System.out.println("waiting");	
		}
		System.out.println("ptrinting start2");
		painter.image(start_screen2,0,0);
		
	}

	public void write_Text(boolean valid) {
	
	}
	
	public boolean game_paused(){
		return show_screen == 2;
	}
	
	public void write_Start() {
		
	}
}
