package Data;

import Logic.*;

import java.util.Random;

//at the beginning bonuses are invisible and not falling because they are hidden in bricks
public abstract class Bonus extends GameObject {

	public Bonus(String imageFile) {
		super(imageFile);
		// TODO Auto-generated constructor stub
	}

	// return if the bonus is visible or not.
	public boolean isVisible() {
		return true;
	}

	// with constant velocity the bonus is falling.
	public void setVisibleAndFalling() {
		setVelocity( new Velocity( 0, -10));
	}

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	public abstract void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h);

}
