package Data;

//draws the pedal and keeps its length.
public class Pedal extends GameObject {

	public Pedal() {
		super("images/pedal1_normal.png");
		// TODO Auto-generated constructor stub
	}

	// declares variable for the distance to travel each time in pixels
	private int move = 5;

	// declares variables for x and y coordinates

	// constructor that takes in x and y coordinates for pedal

	// moves the pedal left.
	public void moveLeft() {
		Point p = getPosition();
		if (p.getX() > 0) {
			p.setX(p.getX() - 1);
		}
	}

	// moves the pedal right.

	public void moveRight() {
		Point p = getPosition();
		if (p.getX() < 800) {
			p.setX(p.getX() - 1);
		}
	}
	/*
	 * this method redraws game object this method is implemented by every
	 * gameobject itself if it is a ball draws ball, if it is brick draws brick
	 * and so on
	 */

}
