package Data;

//has the bricks whose health's are 2.
public class StrongBrick extends Brick {
	int health = 2;

	public StrongBrick( double x, double y) {
		super("images/brick_strong.png", x, y);
		// TODO Auto-generated constructor stub
	}
	public StrongBrick( ) {
		super("images/brick_strong.png");
		// TODO Auto-generated constructor stub
	}
}
