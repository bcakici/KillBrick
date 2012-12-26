package Data;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * GameObject is an abstract class which is implemented by wall, pedal, ball,
 * bonuses, and bricks.
 */

public abstract class GameObject extends ImageIcon {
	private Point position;
	private Velocity velocity;
	private int height, width;
	private static ImageIcon image;

	public GameObject(String imageFile) {
		super(imageFile);

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
		this.component.setLocation(p);
		// this.setLocation( p);
	}

	/*
	 * redraws game object this method is implemented by every gameobject itself
	 * if it is a ball draws ball, if it is brick draws brick and so on
	 */

	public Velocity getVelocity() {
		return this.velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
}
