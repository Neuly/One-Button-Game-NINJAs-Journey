package obng.model.datastructures;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Actually that is a Linked List of different PIMAGES, it should return a new
 * PIMAGE, that needs to act. If theire are more than just one Image, it should
 * go through it, with an Iterator.
 * 
 * @author Neuly
 */
public class ListOfImages extends LinkedList<PImage> {

	private Iterator<PImage> i = this.iterator();

	/** Empty Constructor */
	public ListOfImages() {
		super();
	}

	/**
	 * Takes a path to a file, and adds the files of the given pattern to this
	 * list
	 * 
	 * @param _file_pattern the 5 characters of the corresponding files int the
	 * source folder
	 */
	public ListOfImages(final String _path_to_images,
			final String _file_pattern, PApplet p) {
		super();
		File folder = new File(_path_to_images);
		for (final File fileEntry : folder.listFiles()) {
			String path_to_actor = fileEntry.getAbsolutePath();
			// blame me ;)
			String name_of_object = fileEntry.getName().substring(0, 5);
			PImage local_pimage = p.loadImage(path_to_actor);

			if (name_of_object.compareTo(_file_pattern) == 0)
				add(local_pimage);

		}
	}

	/**
	 * @return the current image of the actor
	 */
	public PImage next() {
		if (!i.hasNext())
			i = this.iterator();
		return i.next();
	}

}
