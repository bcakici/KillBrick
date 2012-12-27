package Data;

//is an abstract class which keeps the brick types.
public abstract class Brick extends GameObject {

	protected int health;
	private Bonus bonus;

	// constructor takes image
	public Brick(String imagefile, int health) {
		super(imagefile);
		this.health = health;
	}
	public Brick(String imagefile, double x, double y, int health) {
		super(imagefile, x, y);
		this.health = health;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	// checks if brick is broken or not.
	public boolean isExploded() {
		return (health == 0);
	}

	public void decreaseHealth() {
		health--;
		if (bonus != null) {
			bonus.setVisibleAndFalling();
		}
	}
}
