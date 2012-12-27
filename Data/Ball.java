package Data;

//this class corresponds to ball in game
public class Ball extends GameObject {

	
	public Ball() {
		super("images/ball.png");
		// TODO Auto-generated constructor stub
	}

	public void setDefaultVelocity() {
		double randomAngle = Math.random() * 15 + 45;
		double magnitude = 9.0;
		setVelocity(new Velocity(magnitude * Math.cos(randomAngle), magnitude
				* Math.sin(randomAngle)));
	}

	// calculate the reflect ball form
	private void reflectFrom(Point collision) {

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
			vy2 = -vy1;
		}
		setVelocity(new Velocity(vx2, vy2));
	}


	public boolean reflectIfCollision( GameObject o){
		Point collision = getCollision(o);
		if( collision != null){
			reflectFrom( collision);
			return true;
		}
		return false;
	}

}
