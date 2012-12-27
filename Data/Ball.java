package Data;

//this class corresponds to ball in game
public class Ball extends GameObject {

	public Ball() {
		super("images/ball.png");
		// TODO Auto-generated constructor stub
	}

	// calculate the reflect ball form
	public void reflectFrom(Point collision) {

		Point firstPosition = getPosition();
		double x1 = firstPosition.getX();
		double y1 = firstPosition.getY();
		Velocity firstVelocity = getVelocity();
		double vx1 = firstVelocity.getVelocityX();
		double vy1 = firstVelocity.getVelocityY();

		double vx2 = vx1, vy2 = vy1;
		double r = getWidth() / 2;
		if (Math.abs(x1 - collision.getX()) == r) {
			vx2 = -vx1;
		} else if (Math.abs(y1 - collision.getY()) == r) {
			vy2 = -y1;
		}

		setVelocity(new Velocity(vx2, vy2));
	}

	// free the ball from pedal.
	public void free() {
	}

	// attach to ball to pedal.
	public void attachTo(Pedal p) {
	}

	/*
	 * redraws game object this method is implemented by every gameobject itself
	 * if it is a ball draws ball, if it is brick draws brick and so on
	 */
	public void redraw() {
	}

}
