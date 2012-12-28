package Data;

//draws the pedal and keeps its length.
public class Pedal extends GameObject {
	Ball attached;
	
	public Pedal(boolean isSecond) {
		super(isSecond ? "images/pedal2_normal.png" : "images/pedal1_normal.png");
		// TODO Auto-generated constructor stub
	}

	// moves the pedal left.
	public void moveLeft() {
		setVelocity( new Velocity( -5, 0));
	}

	// moves the pedal right.
	public void moveRight() {
		setVelocity( new Velocity( 5, 0));
	}
	
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
		if( attached != null){
			attached.setDefaultVelocity();
			attached = null;
		}
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

	public void changeLength(double lengthMultiplier) {
		
	}

}
