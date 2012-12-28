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
	@Override
	public void gainBonus(GameLogic gl, Pedal p) {
		gl.increaseLives();
	}

}
