//is an abstract class which keeps the brick types.
public abstract class Brick extends GameObject {

    //declare x & y coordinates
    int x, y;

    Bonus bonus;

    private int health;
	private Bonus bonus;

    //declare boolean to determine if brick has been hit
    boolean exploded;

    //constructor takes in x and y coordinates
    public Brick(int x, int y, Bonus b) {
        this.bonus = b;
        this.x = x;
        this.y = y;
        this.exploded = false;
    }

    //set if the brick is hit or not
    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    //gets x coordinate of brick
    public int getX() {
        return x;
    }

    //gets y coordinate of brick
    public int getY() {
        return y;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public boolean hasBonusAndExploded() {
        if(isExploded() && this.bonus != null){
            return true;
        }
        return false;
    }

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

