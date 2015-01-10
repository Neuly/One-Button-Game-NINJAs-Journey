package obng.view;

import java.util.LinkedList;

import javax.imageio.ImageWriter;

import obng.model.datastructures.Actor;
import obng.model.datastructures.Figure;
import obng.view.datastructures.Background;
import obng.view.datastructures.ImageDrawer;
import obng.view.datastructures.TextPainter;
import processing.core.*;

/**
 * The View Class, sorry, here I needed to use more than one Object
 * 
 * @author Neuly
 */
public class View {

	private ImageDrawer imgWri;
	private TextPainter txtPai;
	private Background back;

	/** Construct the view class */
	public View(PApplet painter, int width, int height) {
		super();
		imgWri = new ImageDrawer(painter, width, height);
		txtPai = new TextPainter(painter, width, height);
		back = new Background(painter, width, height);
	}

	/** draws the game screen */
	public void draw(LinkedList<Actor> list_of_actors) {
		back.draw();
		for (final Actor anActor : list_of_actors) {
			imgWri.drawAt(anActor.act(), anActor.move_in_x_axis(0),
					anActor.move_in_y_axis(0));
		}
	}

	private void show_pause_screen() {
		// painter.fill(255, 255, 255);
		// painter.stroke(0, 0, 0);
		// painter.rect(0, 0, width, height);
		// painter.fill(255, 255, 255);
		// painter.textFont(font, 36);
		// painter.textAlign(PApplet.CENTER);
		// painter.text("paused", width / 2, height / 2);
	}

	private void show_start_screen() {
		//
		// // TODO Auto-generated method stub
		// PImage start_screen1 = painter.loadImage(PATH_TO_IMAGES
		// + "startscreen2.JPG");
		//
		// painter.image(start_screen1, 0, 0, width, height);

	}

}
