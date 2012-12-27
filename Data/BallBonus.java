package Data;

import Logic.*;

//increases the number of ball when the player gets that bonus.
//For each ball a ball object is going to be created.
public class BallBonus extends Bonus {
	public BallBonus() {
		super("images/bonus.png");
	}
	public BallBonus(double x, double y) {
		super("images/bonus.png");
	}

	private static int ballsToBeAdded = 2;


	@Override
	public void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h) {
		e.addBalls( ballsToBeAdded);

	}

}
