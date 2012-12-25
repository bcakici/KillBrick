package Logic;

import java.util.Timer;
import java.util.TimerTask;

//controls all the activities from the beginning of game to the end of the game.
public class GameLooper extends Timer{
	//this method starts the game.
	private double start;
	private static double lastTime;
	GameEngine gameEngine;
	public GameLooper( GameEngine e){
		this.gameEngine = e;
	}
	public void start() {
		start = System.currentTimeMillis();
		lastTime = start;
		this.schedule(new TimerTask(){
			@Override
			public void run() {
				loop();
			}
		}, 10);
	}
	
	//this method stops the game.
	public void stop() {
		
	}
	// this is the game loop which is called during the game every time frame refreshes
	public void loop() {
		
	}
}