package Data;
//is an abstract class which keeps the brick types.
public abstract class Brick extends GameObject {

	private int health;
	private Bonus bonus;
	//checks if brick is broken or not.
	public boolean isExploded() {
		return( health == 0);
    }
	public void decreaseHealth(){
		health--;
	}
	// this brick holds bonus sometimes.
	public Bonus getBonus() {
		return bonus;
	}
}
