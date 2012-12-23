
import java.awt.Image;
import java.awt.Rectangle;

package Data;
/*
 * GameObject is an abstract class which is implemented by wall, pedal, ball,
 * bonuses, and bricks.
 */

public abstract class GameObject {

    private Point position;
    private Velocity velocity;
    private int height, width;
	
	private Image image;
	Rectangle rect ;
	boolean out;
	public GameObject(Position p, int width, int height) {
		this.position =p;
		rect = new Rectangle();
		setRect(this.position.getX(),this.position.getY(),width,height);
		
	}

        
	public GameObject(Position p, int width, int height, Velocity v) {
		this.position =p;
		this.width = width;
                this.height = height;
                this.velocity = v;
                rect = new Rectangle();
		
                setRect(this.position.getX(),this.position.getY(),width,height);
                
		
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
    //returns the point the object collides with other object, returns null if not

    public Point getCollision(GameObject o) {
        if (this.position.getX() == o.position.getX() && this.position.getY() == o.position.getY()) {
            return this.position;
        }
    }
    //gets the position of objects.

    public Point getPosition() {
        return this.position;
    }
    //sets and updates the position of objects

    public void setPosition(Point p) {
        this.position = p;
    }
    /*
     * redraws game object this method is implemented by every gameobject itself
     * if it is a ball draws ball, if it is brick draws brick and so on
     */

    public void redraw() {
    }

    public Velocity getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
}
