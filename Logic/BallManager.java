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
		p.attach(firstBall);
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
	public void changeBallSpeeds(double speedMultiplier) {
		for (Ball b : balls) {
			Velocity v = b.getVelocity();
			double vx = v.getVelocityX();
			double vy = v.getVelocityY();

			b.setVelocity(new Velocity(vx*speedMultiplier, vy*speedMultiplier));

		}
	}
	
	public void addBall(double x, double y, GameView gv){
		Ball ball = new Ball();
		gv.add( ball.getView());
		ball.setPosition( new Point( x, y));
		ball.setDefaultVelocity();
		balls.add( ball);
	}

}