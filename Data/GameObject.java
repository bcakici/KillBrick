package Data;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * GameObject is an abstract class which is implemented by wall, pedal, ball,
 * bonuses, and bricks.
 */

public abstract class GameObject {
	private Point position;
	private Velocity velocity;
	private int height, width;
	private JLabel view;
	public GameObject(String imageFile) {
		ImageIcon image = new ImageIcon( imageFile);
		view = new JLabel( image);
		width = image.getIconWidth();
		height = image.getIconHeight();
		position = new Point(0,0);
		velocity = new Velocity(0,0);
	}
	public GameObject(String imageFile, double x, double y) {
		ImageIcon image = new ImageIcon( imageFile);
		view = new JLabel( image);
		width = image.getIconWidth();
		height = image.getIconHeight();
		position = new Point(x,y);
		velocity = new Velocity(0,0);
	}
	public void stop(){
		setVelocity( new Velocity( 0,0));
	}
	public JLabel getView(){
		return view;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isInbound( Point p)
	{
		double x1 = getPosition().getX();
		double y1 = getPosition().getY();      

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
		double x = getPosition().getX();
		double y = getPosition().getY();

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

		double vx = getVelocity().getVelocityX();
		double vy = getVelocity().getVelocityY();  

		if( vx > 0 && isInbound(right)) 
		{
			return right;
		}
		else if( vx < 0 && isInbound(left))  
		{
			return left;
		}
		else if( vy > 0 && isInbound(top)) 
		{
			return top;
		}
		else if( vy < 0 && isInbound(down)) 
		{
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
		view.setBounds((int)p.getX()-width/2, (int)p.getY()-height/2, width, height);
		// this.setLocation( p);
	}

	/*
	 * redraws game object this method is implemented by every gameobject itself
	 * if it is a ball draws ball, if it is brick draws brick and so on
	 */
	public void move( double elapsedTime){
		double x = getPosition().getX();
		double y = getPosition().getY();
		double vx = getVelocity().getVelocityX();
		double vy = getVelocity().getVelocityY();
		double dx = vx * elapsedTime;
		double dy = vy * elapsedTime;
		setPosition( new Point( x + dx, y + dy));
	}
	public Velocity getVelocity() {
		return this.velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
}
