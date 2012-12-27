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

	// returns the point the object collides with other object, returns null if
	// not

	public Point getCollision(GameObject o) {
		if (this.position.getX() == o.position.getX()
				&& this.position.getY() == o.position.getY()) {
			return this.position;
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
