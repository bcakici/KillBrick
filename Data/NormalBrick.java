package Data;

//has the bricks whose health's are 1.
public class NormalBrick extends Brick {

	int health = 1;

	/*
	 * this method redraws game object this method is implemented by every
	 * gameobject itself if it is a ball draws ball, if it is brick draws brick
	 * and so on
	 */
	public NormalBrick() {
		super("images/brick_normal.png");
	}
	public NormalBrick( double x, double y) {
		super("images/brick_normal.png", x, y);
	}

}
