package Logic;

import java.util.ArrayList;

import Data.Brick;
import Data.NormalBrick;
import Data.Pedal;
import Data.Point;
import Data.StrongBrick;
import Data.Wall;
import View.GameView;

/* Game engine holds other logic classes maintain game objects,
 it detects collisions types and redraw objects. */

public class GameEngine {
	private static int MAX_LEVEL = 3;
	private int lives = 3;
	private int level = 0;
	private ArrayList<Brick> bricks;
	private ArrayList<Wall> walls;
	private Pedal pedal1;
	private Pedal pedal2;
	private HighScoreManager highScoreManager;
	private SoundManager soundManager;
	private BallManager ballManager;
	private BonusManager bonusManager;
	private GameLooper gameLooper;
	private KeyboardListener keyboardListener;
	private boolean isMultiplayer;
	private GameView gameView;
	private GameLogic gameLogic;

	// Creates pedals, and most of the properties
	public GameEngine(GameLogic gameLogic, boolean isMultiplayer, boolean isMute) {
		bricks = new ArrayList<Brick>();
		walls = new ArrayList<Wall>();
		
		this.gameLogic = gameLogic;
		gameView = gameLogic.gameView;
		highScoreManager = gameLogic.highScoreManager;
		ballManager = gameLogic.ballManager;
		
		highScoreManager.startNewScore();
		
		soundManager = new SoundManager();
		bonusManager = new BonusManager();
		
		this.isMultiplayer = isMultiplayer;
		lives = 3;
		gameView.setLivesText( lives);
		
		createNextLevel();
		
		gameLooper = new GameLooper( this);
		gameLooper.start();

		keyboardListener = new KeyboardListener(pedal1, pedal2, this);
		gameView.addKeyListener(keyboardListener);
		gameView.setFocusable(true);
		gameView.requestFocusInWindow();
		
		if( !isMute){
			soundManager.startBackgroundMusic();
		}
	}

	private void completeLevel(){
		if( level < MAX_LEVEL){
			removeGameObjects();
			createNextLevel();
			gameView.requestFocusInWindow();
		} else{
			gameView.closeAndShowHighScores();
			gameLooper.stop();
		}
	}

	// Elapse method calls redrawObject method and calculateCollisions method.
	public void elapse(double time) {
		moveObjects( time);
		ballManager.handleFalls( gameView);
		bonusManager.handleFalls( gameView);
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
		bonusManager.moveBonuses( elapsedTime);
		stopPedalsIfCollide();
		pedal1.move( elapsedTime);
		if( isMultiplayer){
			pedal2.move( elapsedTime);
		}
	}

	/*
	 * calculates the type of collision and according to result calls other
	 * methods if necessary. There are four collision types that should be
	 * calculated such as between Ball-Brick, Ball - Pedal, Ball - Wall, Bonus -
	 * Pedal.
	 */
	private void makeCollisions() {
		ballManager.makeBallCollisions(this, bricks, walls, pedal1, pedal2);
		bonusManager.makeBonusCollisionsWith(pedal1, gameLogic);
		if (isMultiplayer) {
			bonusManager.makeBonusCollisionsWith(pedal2, gameLogic);
		}
	}
	public void stopPedalsIfCollide(){
		stopIfCollideWithWalls(pedal1);
		if( isMultiplayer){
			pedal1.stopIfCollide( pedal2);
			pedal2.stopIfCollide( pedal1);
			stopIfCollideWithWalls(pedal2);
		}
	}
	private void stopIfCollideWithWalls( Pedal p){
		for( Wall wall: walls){
			p.stopIfCollide( wall);
		}
	}
	public void handleCollision( Brick brick){
		brick.decreaseHealth();
		if (brick.isExploded()) {
			highScoreManager.addScoreToCurrentGame( brick.getScore());
			bricks.remove(brick);
			gameView.remove( brick.getView());
			gameView.repaint();
			gameView.setScoreText( highScoreManager.getLastScore());
		}
	}

	private void removeGameObjects() {
		gameView.removeAll();
		ballManager.removeBalls();
		bonusManager.removeBonuses();
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
			for( int i = 1; i < 8; i++){
				for( int k = 1; k < 4; k++){
					addBrick( i, k, ( i == 2 || i == 6));
				}
			}
		} else if (level == 2) {
			
			for( int i = 1; i < 8; i++){
				for( int k = 1; k < 5; k++){
					addBrick( i, k, ( i % 2 == 1));
				}
			}

		} else if (level == 3) {

			for( int i = 1; i < 8; i++){
				for( int k = 1; k < 6; k++){
					addBrick( i, k, ( k % 2 == 1));
				}
			}
		}

	}
	private void addPedals(){
		if( pedal1 == null){
			pedal1 = new Pedal( false);
		}
		gameView.add( pedal1);
		pedal1.setPosition( new Point( 600, 500));
		if( isMultiplayer){
			if( pedal2 == null){
				pedal2 = new Pedal( true);
			}
			gameView.add( pedal2);
			pedal2.setPosition( new Point( 200, 500));
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
		Brick brick;
		if (isStrong) {
			brick = new StrongBrick();
		} else {
			brick = new NormalBrick();
		}
		brick.setPosition(new Point((column + 0.5) * brick.getWidth(),
				(row + 1.5) * brick.getHeight()));
		gameView.add(brick);
		bricks.add(brick);
		bonusManager.createRandomBonus( brick, gameView);
		return brick;
	}
	public void increaseLives() {
		lives++;
		gameView.setLivesText( lives);
	}
	private void addStartingBall(){
		pedal1.attach( ballManager.addBall( gameView));
	}
	public void decreaseLives() {
		bonusManager.removeFallingBonuses( gameView);
		if (lives == 0) {
			gameView.closeAndShowHighScores();
		} else {
			lives--;
			gameView.setLivesText( lives);
			addStartingBall();
		}
	}
}
