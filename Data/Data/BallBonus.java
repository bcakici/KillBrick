package Data;

import Logic.*;

//increases the number of ball when the player gets that bonus.
//For each ball a ball object is going to be created.
public class BallBonus extends Bonus {
	public BallBonus(String imageFile) {
		super(imageFile);
		// TODO Auto-generated constructor stub
	}
	private int ballCount;
	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw()
	{
    }
	@Override
	public void gainBonus(GameEngine e, Pedal p, BallManager b,
			HighScoreManager h) {
		// TODO Auto-generated method stub
		
	}

}
