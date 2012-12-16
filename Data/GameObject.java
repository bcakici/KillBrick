package Data;
/*GameObject is an abstract class which is implemented by wall,
 *pedal, ball, bonuses, and bricks. */
public abstract class GameObject {

	private Point position;
	private Velocity velocity;

	//returns the point the object collides with other object, returns null if not
	public Point getCollision(GameObject o)
	{

	}

	//gets the position of objects.
	public Point getPosition()
	{
        return position;
	}

	//sets and updates the position of objects
	public void setPosition(Point p)
	{
        this.position = position;
	}

	/* redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw()
	{

	}
}
