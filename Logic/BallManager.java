package Logic;

import java.util.ArrayList;

import View.GameView;
import View.ViewController;

import Data.Ball;
import Data.Brick;
import Data.Pedal;
import Data.Point;
import Data.Velocity;
import Data.Wall;

/* it controls ball objects GameEngine*/
public class BallManager {
	private ArrayList<Ball> balls;
	public BallManager(){
		balls = new ArrayList<Ball>();
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

	public Ball addBall(double x, double y, GameView gv){
		Ball ball = addBall( gv);	
		ball.setPosition( new Point( x, y));
		return ball;
	}
	public Ball addBall(GameView gv){
		Ball ball = new Ball();
		gv.add( ball.getView());
		balls.add( ball);
		return ball;
	}
	public void addBalls( int count, GameView gv){
		for( int i = 0; i < count; i++){
			addBall( balls.get(0).getPosition().getX(), balls.get(0).getPosition().getY(), gv)
					.setDefaultVelocity();
		}
	}
	public void makeBallCollisions( GameEngine e, ArrayList<Brick> bricks, ArrayList<Wall> walls, Pedal pedal1, Pedal pedal2) {
		for (Ball ball : balls) {
			ball.reflectIfCollision(pedal1);
			for (Brick brick : bricks) {
				if (ball.reflectIfCollision(brick)) {
					e.handleCollision( brick);
					break;
				}
			}
			for (Wall wall : walls) {
				ball.reflectIfCollision(wall);
			}
			if (pedal2 != null) {
				ball.reflectIfCollision(pedal2);
			}
		}
	}

	public void handleFalls(GameView gv) {
		for( Ball ball : balls){
			if( ball.getPosition().getY()>620){
				gv.remove( ball.getView());
				balls.remove(ball);
				break;
			}
		}
	}

	public boolean hasBalls() {
		return (balls.size() > 0);
	}

	public void removeBalls(){
		balls = new ArrayList<Ball>();
		
	}

}