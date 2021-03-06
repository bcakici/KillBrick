package Data;

import Logic.*;

//gives extra points to user when the user catch that bonus.
public class ScoreBonus extends Bonus {
	public ScoreBonus() {
		super("images/bonus.png");
	}
	public ScoreBonus(double x, double y) {
		super("images/bonus.png");
	}

	private static int score = 250;

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	@Override
	public void gainBonus(GameLogic gl, Pedal p) {
		gl.addScoreToCurrentGame( score);
	}

}
