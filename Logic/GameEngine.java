package Logic;

import java.util.ArrayList;

import javax.swing.JLabel;

import Data.Ball;
import Data.BallBonus;
import Data.Bonus;
import Data.Brick;
import Data.LifeBonus;
import Data.NormalBrick;
import Data.Pedal;
import Data.PedalLengthBonus;
import Data.Point;
import Data.ScoreBonus;
import Data.SpeedBonus;
import Data.StrongBrick;
import Data.Velocity;
import Data.Wall;
import View.GameView;
import View.ViewController;

/* Game engine holds other logic classes maintain game objects,
 it detects collisions types and redraw objects. */

public class GameEngine {
	private int playersHealth = 3;
	private ArrayList<Bonus> bonuses;
	private ArrayList<Brick> bricks;
	private ArrayList<Wall> walls;
	private Pedal pedal;
	private Pedal pedal2;
	private HighScoreManager highScoreManager;
	private SoundManager soundManager;
	private BallManager ballManager;
	private GameLooper gameLooper;
	private KeyboardListener keyboardListener;
	private boolean isMultiplayer;
	private GameView gameView;

	// Creates pedals, and most of the properties
	public GameEngine(GameView gv, boolean isMultiplayer) {
		bonuses = new ArrayList<Bonus>();
		bricks = new ArrayList<Brick>();
		walls = new ArrayList<Wall>();
		pedal = new Pedal();
		if (isMultiplayer) {
			pedal2 = new Pedal();
		}
		highScoreManager = new HighScoreManager();
		soundManager = new SoundManager();
		ballManager = new BallManager();
		gameLooper = new GameLooper(this);
		keyboardListener = new KeyboardListener(this);
		gameView = gv;

		gameView.addKeyListener(keyboardListener);
		gameView.setFocusable(true);
		gameView.requestFocusInWindow();
		
		this.isMultiplayer = isMultiplayer;
		
		gameLooper.start();
	}

	// in multiplayer game if two padals is collide.
	public boolean isPedalsCollide() {
		if (isMultiplayer) {
			return (pedal.getCollision(pedal2) != null);
		}
		return false;
	}

	// it destroy nessecary objects like brick, ball..
	public void destroyObjects() {
	}

	// it is stop the game.
	public void stopGame() {
	}

	// Elapse method calls redrawObject method and calculateCollisions method.
	public void elapse(double time) {
		moveObjects( time);
		calculateCollisions();
	}
	private void moveObjects( double elapsedTime){
		ballManager.moveBalls( elapsedTime);
		for (Bonus bonus : bonuses) {
			bonus.move( elapsedTime);
		}
		pedal.move( elapsedTime);
		if( isMultiplayer){
			pedal2.move( elapsedTime);
		}
	}

	public Bonus getRandomBonus() {
		Bonus bonus;
		switch ((int) (Math.random() * 4)) {
		case 0:
			bonus = new BallBonus("");
			break;
		case 1:
			bonus = new LifeBonus("");
			break;
		case 2:
			bonus = new PedalLengthBonus("");
			break;
		case 3:
			bonus = new ScoreBonus("");
			break;
		default:
			bonus = new SpeedBonus("");
			break;
		}
		return bonus;
	}

	// it takes the id of the pedal and direction of the pedal
	// as a parameter and enables to move the pedal.
	public void movePedal(int pedalsNumber, boolean direction) {
	}

	/*
	 * calculates the type of collision and according to result calls other
	 * methods if necessary. There are four collision types that should be
	 * calculated such as between Ball-Brick, Ball - Pedal, Ball - Wall, Bonus -
	 * Pedal.
	 */
	private void calculateCollisions() {
		calculateBallCollisions();
		calculateBonusCollisions();
	}

	private void calculateBonusCollisions() {
		for (Bonus bonus : bonuses) {
			Point collision = bonus.getCollision(pedal);
			if (collision != null) {
				bonus.gainBonus(this, pedal, ballManager, highScoreManager);
			} else if (isMultiplayer) {
				collision = bonus.getCollision(pedal2);
				if (collision != null) {
					bonus.gainBonus(this, pedal2, ballManager, highScoreManager);
				}
			}
		}
	}

	private void calculateBallCollisions() {
		ArrayList<Ball> balls = ballManager.getBalls();
		for (Ball ball : balls) {
			Point collision;
			for (Brick brick : bricks) {
				collision = ball.getCollision(brick);
				if (collision != null) {
					brick.decreaseHealth();
					if (brick.isExploded()) {
						Bonus b = brick.getBonus();
						if (b != null) {
							b.setVisibleAndFalling();
						}
					}
					break;
				}
			}
			for (Wall wall : walls) {
				collision = ball.getCollision(wall);
			}
			collision = ball.getCollision(pedal);
			if (isMultiplayer) {
				collision = ball.getCollision(pedal2);
			}
			if (collision != null) {
				ball.reflectFrom(collision);
			}
		}
	}

	// updates the changes to the screen.
	public void redrawObjects() {

	}

	// Creates levels with intializing brick objects.
	public void createLevel(int no) {
		//NormalBrick b = new NormalBrick();
		//gameView.add(new JLabel(b));
		//StrongBrick s = new StrongBrick();
		//gameView.add(new JLabel(s));
		pedal = new Pedal();
		gameView.add(pedal.getView());
		Ball ball = new Ball();
		gameView.add( ball.getView());
		ball.setPosition( new Point( 400, 400));
		pedal.setPosition( new Point( 200, 200));
	}

	public void increasePlayersHealth() {
		playersHealth++;
	}

	public Pedal getPedal1() {
		return pedal;
	}

	public Pedal getPedal2() {
		if (isMultiplayer) {
			return pedal2;
		} else {
			return getPedal1();
		}
	}

	public void decreasePlayersHealth() {
		if (playersHealth == 0) {
			stopGame();
		} else {
			playersHealth--;
		}
	}
}
