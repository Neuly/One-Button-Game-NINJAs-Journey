package obng.datastructures;

/**
 * Gets extended by the Counter.java class. The main idea is, that the internal
 * counter gets increased everytime the object gets accessed. Whenever it gets
 * accessed, it is asked, if its time for the next whatever.
 * 
 * @author Neuly
 * 
 */
public class Timer extends Counter {

	private int border;

	/**
	 * The Constructor
	 * 
	 * @param time
	 *            - when it is the next action for whatever
	 */
	public Timer(int time) {
		super(0);
		border = time;
	}

	/**
	 * whenever the border is reached, this method returns true, false else
	 */
	public boolean is_it_time() {
		up();
		if (times() >= border) {
			reset();
			return true;
		}
		return false;
	}

}
