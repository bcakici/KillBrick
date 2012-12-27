package Logic;

import java.util.Timer;
import java.util.TimerTask;

//controls all the activities from the beginning of game to the end of the game.
public class GameLooper extends Timer {
	// this method starts the game.
	private double start;
	private static double lastTime;
	private GameEngine gameEngine;
	private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			loop();
		}
	};

	public GameLooper(GameEngine e) {
		this.gameEngine = e;
	}

	public void start() {
		start = System.currentTimeMillis();
		lastTime = start;
		this.scheduleAtFixedRate(task, 10, 10);
	}

	// this method stops the game.
	public void stop() {
		this.cancel();
	}

	// this is the game loop which is called during the game every time frame
	// refreshes
	public void loop() {
		gameEngine.elapse((System.currentTimeMillis() - lastTime)/20);
		lastTime = System.currentTimeMillis();
	}
}