package Data;

//this class corresponds to ball in game
public class Ball extends GameObject {

	
	public Ball() {
		super("images/ball.png");
		// TODO Auto-generated constructor stub
	}

	public void setDefaultVelocity() {
		double randomAngle = (Math.random() * 25 + 30) * Math.PI / 180;
		double magnitude = 9.0;
		setVelocity(new Velocity(magnitude * Math.cos(randomAngle), magnitude
				* Math.sin(randomAngle)));
	}
	@Override
	public Point getCollision(GameObject o) {
		double x = getX();
		double y = getY();

		double leftX  = x - width/2;
		double leftY  = y;
		Point left = new Point(leftX, leftY); 

		double rightX = x + width/2;
		double rightY = y;
		Point right = new Point(rightX, rightY);  

		double topX   = x;
		double topY   = y + height/2;
		Point top = new Point(topX, topY);

		double downX  = x;
		double downY  = y - height/2;
		Point down = new Point(downX, downY);

		double vx = getVelocityX();
		double vy = getVelocityY();  

		if (vx > 0 && o.isInbound(right)) {
			return right;
		} else if (vx < 0 && o.isInbound(left)) {
			return left;
		} else if (vy > 0 && o.isInbound(top)) {
			return top;
		} else if (vy < 0 && o.isInbound(down)) {
			return down;
		}
		return null;
	}

	// calculate the reflect ball form
	private void reflectFrom(Point collision) {

		double x1 = getX();
		double y1 = getY();
		double vx1 = getVelocityX();
		double vy1 = getVelocityY();

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
