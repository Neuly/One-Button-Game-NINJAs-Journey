package obng.view.datastructures;

import obng.model.datastructures.Timer;

/**
 * Represents the current Game Status, is paused, is whatever
 * 
 * @author Neuly
 */
public class GameStatus {

	private int status;

	private Timer startScreen;

	/** Constructor for game_status */
	public GameStatus() {
		status = 0;
		startScreen = new Timer(60);
	}

	/** returns true, if the current screen to display is the start screen */
	public boolean startscreen() {
		if (startScreen.is_it_time()) {
			status+=2;
			return false;
		}
		return status == 0;
	}

	/** returns true, when the game should run */
	public boolean gamescreen() {
		return status == 1;
	}
	
	/** returns true, when the game is paused */
	public boolean gamespaused() {
		return status == 2;
	}

	/** sets the status to the next one */
	public void nextStatus() {
		status = ((status + 1) % 3) + 1;
	}

}
