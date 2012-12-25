package Logic;
import Data.*;

import java.util.ArrayList;
/* it controls ball objects GameEngine*/
public class BallManager {
	private ArrayList<Ball> balls;
	// before the game start this method is called to attach the first ball to pedal
	public void attachFirstBallTo( Pedal p) {
		Ball firstBall = balls.get( 0);
		firstBall.attachTo( p);
	}
	// returns all balls that are active
	public ArrayList<Ball> getBalls() {
		return balls;
	}
	// while the ball is moving this method updates the ball position.
	public void redrawBalls() {
		for( Ball b: balls){
			b.redraw();
		}
	}
	// unattach the first ball form pedal, and start moving it
	public void unattachFirstBall() {

		Ball firstBall = balls.get( 0);
		firstBall.free();
	}
	public void increaseSpeed()
	{
		for( Ball b: balls){
			Velocity v = b.getVelocity();
			double x = v.getVelocityX();
			double y = v.getVelocityY();
			
			x = 2*x;
			y = 2*y;
			
			b.setVelocity(new Velocity(x,y));
			
		}
	}
}