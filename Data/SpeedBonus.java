//accelerate or deaccelerate the ball speed.
public class SpeedBonus extends Bonus {
	private double speedMultiplier;
	// every bonuses implement this method differently, each bonus call it related methods.
	public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h) {
            b.increaseSpeed();
        }
	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

}
