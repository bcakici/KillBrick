package Data;

//is an abstract class which keeps the brick types.
public abstract class Brick extends GameObject {

	// declare x & y coordinates
	int x, y;

	private int health;
	private Bonus bonus;

	// declare boolean to determine if brick has been hit
	boolean exploded;

	// constructor takes image
	public Brick(String imagefile) {
		super(imagefile);
	}
	public Brick(String imagefile, double x, double y) {
		super(imagefile, x, y);
	}

	// set if the brick is hit or not
	public void setExploded(boolean exploded) {
		this.exploded = exploded;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public boolean hasBonusAndExploded() {
		if (isExploded() && this.bonus != null) {
			return true;
		}
		return false;
	}

	// checks if brick is broken or not.
	public boolean isExploded() {
		return (health == 0);
	}

	public void decreaseHealth() {
		health--;
	}

	// this brick holds bonus sometimes.
	public Bonus getBonus() {
		return bonus;
	}
}
