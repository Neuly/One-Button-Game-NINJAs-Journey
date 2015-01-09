package obng.model.datastructures;

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

	private boolean paused;

	/**
	 * The Constructor
	 * 
	 * @param time - when it is the next action for whatever
	 */
	public Timer(int time) {
		super(0);
		border = time;
		paused = false;
	}

	/**
	 * whenever the border is reached, this method returns true, false else
	 */
	public boolean is_it_time() {
		if (!paused)
			up();
		if (times() >= border) {
			reset();
			return true;
		}
		return false;
	}

	/**
	 * When the game should pase, the timer is not allowed to count up, so set
	 * the paused variable in this method
	 */
	public void pause_or_continue(boolean status_paused) {
		paused = status_paused;
	}

}
