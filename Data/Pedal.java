package Data;

//draws the pedal and keeps its length.
public class Pedal extends GameObject {
	Ball attached;
	
	public Pedal(boolean isSecond) {
		super(isSecond ? "images/pedal2_normal.png" : "images/pedal1_normal.png");
		// TODO Auto-generated constructor stub
	}

	// declares variable for the distance to travel each time in pixels
	private int move = 5;

	// declares variables for x and y coordinates

	// constructor that takes in x and y coordinates for pedal

	// moves the pedal left.
	public void moveLeft() {
		setVelocity( new Velocity( -5, 0));
	}

	// moves the pedal right.
	@Override 
	public void setPosition(Point p) {
		super.setPosition(p);
		if( attached != null){
			attached.setPosition( new Point( p.getX() - getWidth()/4, p.getY() - attached.getHeight()/2 - height/2));
		}
	}
	public void attach( Ball b){
		attached = b;
		attached.stop();
		setPosition( getPosition());
	}
	public void freeBall(){
		attached.setDefaultVelocity();
		attached = null;
	}
	public void moveRight() {
		setVelocity( new Velocity( 5, 0));
	}
	public void stopIfCollide( GameObject o){
		Point collision = getCollision(o);
		if( collision != null){
			Point position = getPosition();
			double x = position.getX();
			Velocity velocity = getVelocity();
			double vx = velocity.getVelocityX();
			if (vx < 0 && (x - collision.getX() == width/2)) {
				stop();
			} else if (vx > 0 && (collision.getX() - x == width/2)) {
				stop();
			} 
		}
	}
	/*
	 * this method redraws game object this method is implemented by every
	 * gameobject itself if it is a ball draws ball, if it is brick draws brick
	 * and so on
	 */

}
