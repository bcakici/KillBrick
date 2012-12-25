package Data;
//has the bricks whose health's are 2.
public class StrongBrick extends Brick {

	public StrongBrick(String imagefile) {
		super(imagefile);
		// TODO Auto-generated constructor stub
	}

	int health = 2;

	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw()
	{

	}
}
