package Data;
//gives extra points to user when the user catch that bonus.
public class ScoreBonus extends Bonus {
	private int score;
	// every bonuses implement this method differently, each bonus call it related methods.
	public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h) {
            h.addScoreToCurrentGame(10);
        }
	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

}
