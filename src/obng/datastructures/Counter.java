package obng.datastructures;

/**
 * 
 * A Counter class, used for counting up and downwards. Basically needed for
 * 
 * @author Neuly
 */
public class Counter {

	private int internal_counter;

	/**
	 * The constructor
	 * 
	 * @param _start_value
	 *            - internal_counter gets set to start_value
	 */
	public Counter(int _start_value) {
		this.internal_counter = _start_value;
	}

	/** counts the counter up by one */
	public int up() {
		return internal_counter++;
	}

	/** counts the counter down by one */
	public int down() {
		return internal_counter--;
	}

	/** returns the internal_counter */
	public int times() {
		return internal_counter;
	}

	/** resets the internal_counter */
	public int reset() {
		internal_counter = 0;
		return internal_counter;
	}

}
