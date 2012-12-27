package Data;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * GameObject is an abstract class which is implemented by wall, pedal, ball,
 * bonuses, and bricks.
 */

public abstract class GameObject {
	private Point position;
	private Velocity velocity;
	protected JLabel view;
	protected double height;
	protected double width;
	public GameObject(String imageFile) {
		setView( imageFile);
		setPosition( 0, 0);
		stop();
	}
	public GameObject(String imageFile, double x, double y) {
		this( imageFile);
		setPosition( x, y);
	}
	protected void setView(String imageFile){
		ImageIcon image = null;
		try {
			image = new ImageIcon( new URL(getClass().getProtectionDomain().getCodeSource().getLocation(), imageFile));
		
		} catch (MalformedURLException e) {
			System.out.println( "image not found: " + imageFile);
		}

		if( view == null){
			view = new JLabel( image);
		}
		else{ 
			view.setIcon(image);
		}
		width = image.getIconWidth();
		height = image.getIconHeight();
		
	}
	public void stop(){
		setVelocity( new Velocity( 0,0));
	}
	public JLabel getView(){
		return view;
	}
	public double getHeight() {
		return height;
	}
	protected void setHeight(int height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	protected void setWidth(int width) {
		this.width = width;
	}

	public boolean isInbound( Point p)
	{
		double x1 = getX();
		double y1 = getY();      

		double x2 = p.getX();
		double y2 = p.getY();

		if( (x1 + width/2) >= x2 &&  x2 >= (x1 - width/2) 
				&& (y1 + height/2) >= y2 &&  y2 >= (y1 - height/2) ){
			return true;
		}
		
		return false;
	}
	// returns the point the object collides with other object, returns null if
	// not

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
	
	// gets the position of objects.
	public Point getPosition() {
		return this.position;
	}

	// sets and updates the position of objects
	public void setPosition(Point p) {
		this.position = p;
		view.setBounds((int) (p.getX() - width / 2),
				(int) (p.getY() - height / 2), (int) width, (int) height);
	}
	public void setPosition( double x, double y){
		this.setPosition( new Point( x, y));
	}
	public void setX( double x){
		this.setPosition( new Point(x, getY()));
	}
	public void setY( double y){
		this.setPosition( new Point( getX(), y));
	}
	public double getX(){
		return getPosition().getX();
	}
	public double getY(){
		return getPosition().getY();
	}

	public void setVelocity( double vx, double vy){
		this.setVelocity( new Velocity( vx, vy));
	}
	public void setVelocityX( double vx){
		this.setPosition( new Point(vx, getVelocityY()));
	}
	public void setVelocityY( double vy){
		this.setPosition( new Point( getVelocityX(), vy));
	}
	public double getVelocityX(){
		return getVelocity().getVelocityX();
	}
	public double getVelocityY(){
		return getVelocity().getVelocityY();
	}

	public void move( double elapsedTime){
		setPosition( new Point( getX() + getVelocityX() * elapsedTime, 
								getY() + getVelocityY() * elapsedTime));
	}
	public Velocity getVelocity() {
		return this.velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
}
