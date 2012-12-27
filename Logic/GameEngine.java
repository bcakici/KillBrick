package Logic;

import java.util.ArrayList;

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
import Data.Wall;
import View.GameView;

/* Game engine holds other logic classes maintain game objects,
 it detects collisions types and redraw objects. */

public class GameEngine {
	private int lives = 3;
	private int level = 0;
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
		keyboardListener = new KeyboardListener(this);
		gameView = gv;

		gameView.addKeyListener(keyboardListener);
		gameView.setFocusable(true);
		gameView.requestFocusInWindow();
		
		this.isMultiplayer = isMultiplayer;
		lives = 3;
		
		createNextLevel();
		runGame();
	}


	private void runGame(){
		gameLooper = new GameLooper( this);
		gameLooper.start();
	}
	// it is stop the game.
	public void stopGame() {
		gameLooper.stop();
	}
	private void completeLevel(){
		stopGame();
		removeGameObjects();
		createNextLevel();
		runGame();
	}

	// Elapse method calls redrawObject method and calculateCollisions method.
	public void elapse(double time) {
		moveObjects( time);
		ballManager.handleFalls( gameView);
		if( !ballManager.hasBalls()){
			decreaseLives();
		}
		else if( bricks.size() == 0){
				completeLevel();
		}
		else{
			makeCollisions();
		}
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

	public Bonus createRandomBonus( Brick brick) {
		Bonus bonus;
		switch (0){//(int) (Math.random() * 14)) {
		case 0:
			bonus = new BallBonus();
			break;
		case 1:
			bonus = new LifeBonus();
			break;
		case 2:
			bonus = new PedalLengthBonus();
			break;
		case 3:
			bonus = new ScoreBonus();
			break;
		case 4:
			bonus = new SpeedBonus();
			break;
		default:
			bonus = null;
			break;
		}
		if (bonus != null) {
			brick.setBonus(bonus);
			gameView.add( bonus.getView());
			bonuses.add(bonus);
		}
		return bonus;
	}
	public void addBalls( int count){
		ballManager.addBalls(count, gameView);
	}
	/*
	 * calculates the type of collision and according to result calls other
	 * methods if necessary. There are four collision types that should be
	 * calculated such as between Ball-Brick, Ball - Pedal, Ball - Wall, Bonus -
	 * Pedal.
	 */
	private void makeCollisions() {
		ballManager.makeBallCollisions(this, bricks, walls, getPedal1(), getPedal2());
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
				gameView.remove(bonus.getView());
				gameView.repaint();
				bonuses.remove( bonus);
				break;
			} else if (isMultiplayer) {
				collision = bonus.getCollision(pedal2);
				if (collision != null) {
					bonus.gainBonus(this, pedal2, ballManager, highScoreManager);
					gameView.remove(bonus.getView());
					gameView.repaint();
					bonuses.remove( bonus);
					break;
				}
			}
		}
	}
	public void handleCollision( Brick brick){
		brick.decreaseHealth();
		if (brick.isExploded()) {
			bricks.remove(brick);
			gameView.remove( brick.getView());
			gameView.repaint();
		}
	}

	private void removeGameObjects() {
		gameView.removeAll();
		ballManager.removeBalls();
		bonuses.clear();
		walls.clear();
		bricks.clear();
	}
	// Creates levels with creating game objects.
	public void createNextLevel() {
		level++;
		addBricks( level);
		addPedals();
		addWalls();
		addStartingBall();
		gameView.repaint();
	}
	private void addBricks(int level){
		if (level == 1) {
			for( int i = 1; i < 10; i++){
				for( int k = 1; k < 4; k++){
					addBrick( i, k, false);
				}
			}
		} else if (level == 2) {
			
			for( int i = 1; i < 10; i++){
				for( int k = 1; k < 4; k++){
					addBrick( i, k, true);
				}
			}

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
	private Brick addBrick( int column, int row, boolean isStrong){
		if (isStrong) {
			StrongBrick brick = new StrongBrick();
			brick.setPosition(new Point((column - 0.5) * brick.getWidth(),
					(row - 0.5) * brick.getHeight()));
			gameView.add(brick.getView());
			bricks.add(brick);
			createRandomBonus( brick);
			return brick;
		} else {
			NormalBrick brick = new NormalBrick();
			brick.setPosition(new Point((column - 0.5) * brick.getWidth(),
					(row - 0.5) * brick.getHeight()));
			gameView.add(brick.getView());
			bricks.add(brick);
			createRandomBonus( brick);
			return brick;
		}
	}
	public void increaseLives() {
		lives++;
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
	private void addStartingBall(){
		pedal.attach( ballManager.addBall( gameView));
	}
	public void decreaseLives() {
		removeFallingBonuses();
		if (lives == 0) {
			stopGame();
		} else {
			lives--;
			addStartingBall();
		}
	}
	public void removeFallingBonuses(){
		for( int i = 0; i < bonuses.size(); i++){
			Bonus bonus = bonuses.get(i);
			if( bonus.isVisible()){
				gameView.remove( bonus.getView());
				gameView.repaint();
				bonuses.remove( bonus);
				i--;
			}
		}
	}
}
