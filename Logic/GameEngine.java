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
	}

	// in multiplayer game return if two pedals is collide.
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
		stopPedalsIfCollide();
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
	/*
	 * calculates the type of collision and according to result calls other
	 * methods if necessary. There are four collision types that should be
	 * calculated such as between Ball-Brick, Ball - Pedal, Ball - Wall, Bonus -
	 * Pedal.
	 */
	private void calculateCollisions() {
		makeBallCollisions();
		makeBonusCollisions();
	}
	public void stopPedalsIfCollide(){
		stopIfCollideWithWalls(pedal);
		if( isMultiplayer){
			pedal.stopIfCollide( pedal2);
			pedal2.stopIfCollide( pedal);
			stopIfCollideWithWalls(pedal2);
		}
	}
	private void stopIfCollideWithWalls( Pedal p){
		for( Wall wall: walls){
			p.stopIfCollide( wall);
		}
	}

	private void makeBonusCollisions() {
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
	private void handleCollision( Brick brick){
		brick.decreaseHealth();
		if (brick.isExploded()) {
			bricks.remove(brick);
			gameView.remove( brick.getView());
			gameView.repaint();
		}
	}
	private void makeBallCollisions() {
		ArrayList<Ball> balls = ballManager.getBalls();
		for (Ball ball : balls) {
			ball.reflectIfCollision(pedal);
			for (Brick brick : bricks) {
				if (ball.reflectIfCollision(brick)) {
					handleCollision( brick);
					break;
				}
			}
			for (Wall wall : walls) {
				ball.reflectIfCollision(wall);
			}
			if (isMultiplayer) {
				ball.reflectIfCollision(pedal2);
			}
		}
	}

	// Creates levels with creating game objects.
	public void createLevel(int level) {
		addBricks( level);
		addPedals();
		addWalls();
		ballManager.addBall( 0, 0, gameView);
		ballManager.attachFirstBallTo( pedal);
		gameLooper.start();
	}
	private void addBricks(int level){
		if (level == 1) {
			addBrick(1,1, true);
			addBrick(2,2, false);
			addBrick(3,3, false);
			addBrick(4,4, true);
		} else if (level == 2) {

		} else if (level == 3) {

		}

	}
	private void addPedals(){
		pedal = new Pedal( false);
		gameView.add( pedal.getView());
		pedal.setPosition( new Point( 200, 500));
		if( isMultiplayer){
			pedal2 = new Pedal( true);
			gameView.add( pedal2.getView());
			pedal2.setPosition( new Point( 600, 500));
		}
	}
	private void addWalls(){
		Wall left = new Wall(-10, 0, 0, 600);
		Wall top = new Wall(0, 800, -10, 0);
		Wall right = new Wall(800, 810, 0, 600);
		walls.add( left);
		walls.add( top);
		walls.add( right);
	}
	private Brick addBrick( double row, double column, boolean isStrong){
		if (isStrong) {
			StrongBrick brick = new StrongBrick();
			brick.setPosition(new Point((row - 1 / 2) * brick.getWidth(),
					(column - 1 / 2) * brick.getHeight()));
			gameView.add(brick.getView());
			bricks.add(brick);
			return brick;
		} else {
			NormalBrick brick = new NormalBrick();
			brick.setPosition(new Point((row - 1 / 2) * brick.getWidth(),
					(column - 1 / 2) * brick.getHeight()));
			gameView.add(brick.getView());
			bricks.add(brick);
			return brick;
		}
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
			return null;
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
