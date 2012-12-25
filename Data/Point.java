<<<<<<< HEAD
package Data;

import Logic.GameObject;
// it keeps cordinate of point x,y in any position.
public class Point {

	private int x;
	private int y;

	// it gets x cordinate
	public int getX()
	{
        return x;
	}

	// it sets x cordinate.
	public void setX(int x)
	{
        this.x = x;
	}

	//it gets y cordinate.
	public int getY()
	{
        return y;
	}

	//it sets y cordinate.
	public void setY(int y)
	{
        this.y = y;
	}
}
=======
package Data;

// it keeps cordinate of point x,y in any position.
public class Point {
	private int x;
	private int y;
	// it gets x cordinate
	public int getX() {
            return this.x;
        }
	// it sets x cordinate.
	public void setX(int x) {
            this.x = x;
        }
	//it gets y cordinate.
	public int getY() {
            return this.y;
        }
	//it sets y cordinate.
	public void setY(int y) {
            this.y = y;
        }
}

