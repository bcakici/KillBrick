package Data;
import Logic.*;
//this class corresponds to ball in game
public class Ball extends GameObject {

	public Ball(String imageFile) {
		super(imageFile);
		// TODO Auto-generated constructor stub
	}
	// calculate the reflect ball form
	public void reflectFrom(Point Collision)
	{

	}
	// free the ball from pedal.
	public void free() {}
	// attach to ball to pedal.
	public void attachTo(Pedal p) {}
	/* redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

}
