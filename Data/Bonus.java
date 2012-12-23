<<<<<<< HEAD
package Data;

import Logic.*;

//at the beginning bonuses are invisible and not falling because they are hidden in bricks
public abstract class Bonus extends GameObject {


	//return if the bonus is visible or not.
	public boolean isVisible()
	{

	}

	//with constant velocity the bonus is falling.
	public void setVisibleAndFalling()
	{

	}

	// every bonuses implement this method differently, each bonus call it related methods.
	abstract public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h);

}
=======
package Data;

import java.util.Random;
//at the beginning bonuses are invisible and not falling because they are hidden in bricks
public abstract class Bonus extends GameObject {
	
    private boolean visible = false;
    
    private Random rgen = new Random();
    private int velocity = 0;
        //return if the bonus is visible or not.
	public boolean isVisible() {
            return this.visible;
        }
	//with constant velocity the bonus is falling.
	public void setVisibleAndFalling() {
            this.visible = true;
            this.velocity = 15 + this.rgen.nextInt(15);
        }
	// every bonuses implement this method differently, each bonus call it related methods. 
	public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h) {}

}
>>>>>>> Data Package-Version 0.0.1
