
import java.util.ArrayList;

import Logic.*;
import Data.*;
/* Game engine holds other logic classes maintain game objects, 
it detects collisions types and redraw objects. */ 

public class GameEngine {
	private ArrayList<Bonus> bonuses;
	private ArrayList<Brick> bricks;
	private ArrayList<Wall> walls;
	private Pedal pedal;
	private Pedal pedal2;
	private HighScoreManager highScoreManager;
	private SoundManager soundManager;
	private BallManager ballManager;
	private GameLooper gameLooper;
	private KeyListener keyListener;
	private boolean isMultiplayer;
	//Creates pedals, and most of the properties
	public void GameEngine(boolean isMultiplayer) {
		bonuses = new ArrayList<Bonus>();
		bricks = new ArrayList<Brick>();
		walls = new ArrayList<Wall>();
		pedal = new Pedal();
		if( isMultiplayer){
			pedal2 = new Pedal();
		}
		highScoreManager = new HighScoreManager();
		soundManager = new SoundManager();
		ballManager = new BallManager();
		gameLooper = new GameLooper();
		keyListener = new KeyListener();
		
		this.isMultiplayer = isMultiplayer;
	}
	// in multiplayer game if two padals is collide. 
	public boolean isPedalsCollide() {
		if( isMultiplayer){
			return( pedal.getCollision(pedal2) != null);
		}
		return false;
	}
	// it destroy nessecary objects like brick, ball..
	public void destroyObjects() {}
	// it is stop the game.
	public void stopGame() {}
	// Elapse method calls redrawObject method and calculateCollisions method.
	public void elapse( int time) {}
	public void createRandomBonus() {}
	//it takes the id of the pedal and direction of the pedal 
	//as a parameter and enables to move the pedal.
	public void movePedal(int pedalsNumber, boolean direction) {}
	/*calculates the type of collision and according to result calls other methods if necessary.
	 * There are four collision types that should be calculated such as between Ball-Brick,
	 * Ball - Pedal, Ball - Wall, Bonus - Pedal.*/
	private void calculateCollisions() {
		ArrayList<Ball> balls = ballManager.getBalls();
		for( Ball ball: balls){
			Point collision;
			for( Brick brick: bricks){
				collision = ball.getCollision(brick);
				if( collision != null){
					ball.reflectFrom(collision);
					brick.decreaseHealth();
					if( brick.isExploded()){
						Bonus b = brick.getBonus();
						if( b != null){
							b.setVisibleAndFalling();
						}
					}
					break;
				}
			}
			for( Wall wall: walls){
				collision = ball.getCollision(wall);
				if( collision != null){
					ball.reflectFrom(collision);
					break;
				}
			}
			
		}
	}
	// updates the changes to the screen.
	private void redrawObjects(int elapsedTime) {}
	// Creates levels with intializing brick objects. 
	public void createLevel(int no) {}
}