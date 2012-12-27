package Data;

import Logic.*;

//can able to length or shorten the pedal.
public class PedalLengthBonus extends Bonus {

	private double lengthMultiplier;
	
	public PedalLengthBonus() {
		super("images/bonus.png");
	}
	public PedalLengthBonus(double x, double y) {
		super("images/bonus.png");
	}


	@Override
	public void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h) {
		p.changeLength( lengthMultiplier);
	}
}
