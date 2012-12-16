
import Logic.*;
import Data.*;
/* Game engine holds other logic classes maintain game objects, 
it detects collisions types and redraw objects. */ 

public class GameEngine {
	private ArrayList<Bonus> bonuses;
	private ArrayList<Brick> bricks;
	private Pedal pedal;
	private Pedal pedal2;
	private HighScoreManager highScoreManager;
	private SoundManager soundManager;
	private BallManager ballManager;
	private GameLooper gameLooper;
	private KeyListener keyListener;
	//Creates pedals, and most of the properties
	public void GameEngine(boolean isMultiplayer) {}
	// in multiplayer game if two padals is collide. 
	public boolean isPedalsCollide() {}
	// it destroy nessecary objects like brick, ball..
	public void destroyObjects() {}
	// it is stop the game.
	public void stopGame() {}
	// Elapse method calls redrawObject method and calculateCollisions method.
	public void elapse( int time) {}
	public void createRandomBonus() {}
	//it takes the id of the pedal and direction of the pedal 
	//as a parameter and enables to move the pedal.
	public void movePedal(Object aPedalsNumber, Object aDirection) {}
	/*calculates the type of collision and according to result calls other methods if necessary.
	 * There are four collision types that should be calculated such as between Ball-Brick,
	 * Ball - Pedal, Ball - Wall, Bonus - Pedal.*/
	private void calculateCollisions() {}
	// updates the changes to the screen.
	private void redrawObjects(int elapsedTime) {}
	// Creates levels with intializing brick objects. 
	public void createLevel(int no) {}
}