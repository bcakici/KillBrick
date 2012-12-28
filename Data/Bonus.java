package Data;

import Logic.*;

//at the beginning bonuses are invisible and not falling because they are hidden in bricks
public abstract class Bonus extends GameObject {

	public Bonus(String imageFile) {
		super(imageFile);
		getView().setVisible( false);
	}
	public Bonus(String imageFile, double x, double y) {
		super(imageFile, x, y);
		getView().setVisible( false);
	}

	// return if the bonus is visible or not.
	public boolean isVisible() {
		return getView().isVisible();
	}

	// with constant velocity the bonus is falling.
	public void setVisibleAndFalling() {
		getView().setVisible( true);
		setVelocity( new Velocity( 0, 2));
		//gv.setComponentZOrder( getView(), 0);
	}

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	public abstract void gainBonus(GameLogic gl, Pedal p);

}
