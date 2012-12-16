import Data.Ball;
/* it controls ball objects GameEngine*/
public class BallManager {
	private ArrayList<Ball> balls;
	// before the game start this method is called to attach the first ball to pedal
	public void attachFirstBallTo( Pedal p) {}
	// returns all balls that are active
	public ArrayList<Ball> getBalls() {	}
	// while the ball is moving this method updates the ball position.
	public void redrawBalls() {}
	// unattach the first ball form pedal, and start moving it
	public void unattachFirstBall() {}
}