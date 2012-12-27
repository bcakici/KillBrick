package Logic;

import java.util.ArrayList;

import View.GameView;
import View.ViewController;

import Data.Ball;
import Data.Pedal;
import Data.Point;
import Data.Velocity;

/* it controls ball objects GameEngine*/
public class BallManager {
	private ArrayList<Ball> balls;
	public BallManager(){
		balls = new ArrayList<Ball>();
	}

	// before the game start this method is called to attach the first ball to
	// pedal
	public void attachFirstBallTo(Pedal p) {
		Ball firstBall = balls.get(0);
		firstBall.attachTo(p);
	}

	// returns all balls that are active
	public ArrayList<Ball> getBalls() {
		return balls;
	}

	// while the ball is moving this method updates the ball position.
	public void moveBalls( double elapsedTime) {
		for (Ball ball : balls) {
			ball.move( elapsedTime);
		}
	}

	// unattach the first ball form pedal, and start moving it
	public void unattachFirstBall() {

		Ball firstBall = balls.get(0);
		firstBall.free();
	}

	public void increaseSpeed() {
		for (Ball b : balls) {
			Velocity v = b.getVelocity();
			double x = v.getVelocityX();
			double y = v.getVelocityY();

			x = 2 * x;
			y = 2 * y;

			b.setVelocity(new Velocity(x, y));

		}
	}
	
	public void addBall(double x, double y, GameView gv){
		Ball ball = new Ball();
		gv.add( ball.getView());
		ball.setPosition( new Point( x, y));
		ball.setVelocity( new Velocity(3,3));
		balls.add( ball);
	}
}