package Data;

// wall is the object around the screen.
// it keeps wall height and width.
public class Wall extends GameObject {
	public Wall(double x1, double x2, double y1, double y2) {
		super("images/wall.png");
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		setPosition(new Point((x1 + x2) / 2, (y1 + y2) / 2));
	}
}
