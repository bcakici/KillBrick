<<<<<<< HEAD
package Data;
//increment the life by one that the user already has.
public class LifeBonus extends Bonus {

	// every bonuses implement this method differently, each bonus call it related methods.
	public void gainBonus(gameEngine e, Pedal p, BallManager b, HighScoreManager h)
	{

	}

	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw()
	{

	}

}
=======
package Data;
//increment the life by one that the user already has.
public class LifeBonus extends Bonus {
	
	// every bonuses implement this method differently, each bonus call it related methods. 
	public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h) {
            
        }
	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

}
>>>>>>> Data Package-Version 0.0.1
