package Data;

import Logic.*;

//increment the life by one that the user already has.
public class LifeBonus extends Bonus {

	public LifeBonus() {
		super("images/bonus.png");
	}
	public LifeBonus(double x, double y) {
		super("images/bonus.png");
	}

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	public void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h) {
		e.increasePlayersHealth();
	}

	/*
	 * this method redraws game object this method is implemented by every
	 * gameobject itself if it is a ball draws ball, if it is brick draws brick
	 * and so on
	 */
	public void redraw() {

	}

}
