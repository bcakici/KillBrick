package Data;

//has the bricks whose health's are 2.
public class StrongBrick extends Brick {
	
	public StrongBrick( double x, double y) {
		super("images/brick_strong.png", x, y, 2);
	}
	public StrongBrick( ) {
		super("images/brick_strong.png", 2);
	}
}
