package Data;

import Logic.*;

//accelerate or deaccelerate the ball speed.
public class SpeedBonus extends Bonus {
	public SpeedBonus() {
		super("images/bonus.png");
	}
	public SpeedBonus(double x, double y) {
		super("images/bonus.png");
	}

	private double speedMultiplier;

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	public void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h) {
		b.increaseBallSpeeds();
	}

}
