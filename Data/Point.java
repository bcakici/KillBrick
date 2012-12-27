package Data;

// it keeps cordinate of point x,y in any position.
public class Point {
	// it gets x cordinate
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	// it sets x cordinate.
	public void setX(double x) {
		this.x = x;
	}

	// it gets y cordinate.
	public double getY() {
		return this.y;
	}

	// it sets y cordinate.
	public void setY(double y) {
		this.y = y;
	}
}
