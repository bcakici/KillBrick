package Data;

import Logic.GameObject;
//at the beginning bonuses are invisible and not falling because they are hidden in bricks
public abstract class Bonus extends GameObject {
	//return if the bonus is visible or not.
	public boolean isVisible() {}
	//with constant velocity the bonus is falling.
	public void setVisibleAndFalling() {}
	// every bonuses implement this method differently, each bonus call it related methods. 
	public void gainBonus(gameEngine e, Pedal p, BallManager b, HighScoreManager h) {}

}