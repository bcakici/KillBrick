package Data;

//has the bricks whose health's are 1.
public class NormalBrick extends Brick {

	public NormalBrick() {
		super("images/brick_normal.png", 1);
	}
	public NormalBrick( double x, double y) {
		super("images/brick_normal.png", x, y, 1);
	}

}
