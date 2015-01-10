package obng.model.datastructures;

import java.util.ArrayList;

/**
 * A Class that makes it able to wrap around
 * 
 * @author Neuly
 */
public class MultipleTimer extends ArrayList<Timer> {

	/** adds an Array of Timer objects to the localy storred array list */
	public MultipleTimer(Timer _toHandle[]) {
		for (Timer local_timer : _toHandle)
			add(local_timer);
	}

	/**
	 * Is it time according to the method in Timer. However, it also needs to
	 * know whicht timer element is needed only counts the given Timer Element
	 * one up!
	 */
	public boolean is_it_time_on_clock(int timer) {
		return get(timer).is_it_time();
	}
	
	/** sets all Elements to the given pasued status */
	public void pause_or_continue(boolean status_paused) {
		for (Timer timer : this) 
			timer.pause_or_continue(status_paused);
	}
	
	/** count alle Elements once up */
	public void refresh_all() {
		for (Timer local_timer : this) 
			local_timer.is_it_time();
	}

}
