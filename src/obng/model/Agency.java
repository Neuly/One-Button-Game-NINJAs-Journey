package obng.model;

import java.io.File;
import java.util.LinkedList;

import obng.model.datastructures.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * An agency that "rents" actors. The basic idea is, that if an object gets
 * requested, represented by the type_of_actor class, it should clone such an
 * object and give it a unique number - so it can get identified.
 * 
 * In this case, actors are only enemies or stones - no caretaking about back-
 * ground or anything else. Another major point - it takes the path to the
 * picture folder, and takes the name of the
 * 
 * @author Neuly
 */
public class Agency extends Counter {

	/** The Hash Map representing kind of actors */
	private TypeOfFigures<Type_of_actor, Figure> types;

	/**
	 * The Constructor for the Agency
	 * 
	 * @param path Takes this path, and takes the filename to create single
	 * objects
	 * @param painter the papplet, required to read the different images
	 */
	public Agency(String path, PApplet p, int start_x, int start_y) {
		super(0);
		types = new TypeOfFigures<Type_of_actor, Figure>();

		ListOfImages local_pimages_list = new ListOfImages();
		String name_old_object = "";
		File folder = new File(path);
		boolean firstrun = true;
		for (final File fileEntry : folder.listFiles()) {
			String path_to_actor = fileEntry.getAbsolutePath();
			// blame me ;)
			String name_of_object = fileEntry.getName().substring(0, 6);
			PImage local_pimage = p.loadImage(path_to_actor);
			if (firstrun) {
				firstrun = false;
				name_old_object = name_of_object;
			}
			if (name_of_object.compareTo(name_old_object) != 0) {
				name_old_object = name_of_object;
				Type_of_actor local_toa = new Type_of_actor(name_of_object,
						up());
				local_pimages_list.reset_iterator();
				Figure local_figure = new Figure(local_pimages_list, start_x,
						start_y, local_toa, "", 0);

				types.put(local_toa, local_figure);
				local_pimages_list = new ListOfImages();
			}

			local_pimages_list.add(local_pimage);

		}
	}

	/** returns a random Enemy */
	public Figure newRandomEnemy() {
		int random_int = (int) (Math.random() * times());
		Type_of_actor local_toa = new Type_of_actor("", random_int);
		return (new Figure(types.get(local_toa)));
	}
}
