<<<<<<< HEAD
package Data;

import Logic.GameObject;
// it keeps velocity of dynamic objects.
public class Velocity {

	private double velocityX;
	private double velocityY;

	// get the velocity of x cordinate.
	public double getVelocityX()
	{
         return velocityX;
	}

	// set the velocity of x cordinate.
	public void setVelocityX(double aVelocityX)
	{
        this.velocityX = velocityX;
	}

	// get the velocity of y cordinate.
	public double getVelocityY()
	{
        return velocityY;
	}
	// set the velocity of y cordinate.
	public void setVelocityY(double aVelocityY)
	{
        this.velocityY = velocityY;
	}
}
=======
package Data;

// it keeps velocity of dynamic objects. 
public class Velocity {
	private double velocityX;
	private double velocityY;
	// get the velocity of x cordinate.
	public double getVelocityX() {
            return this.velocityX;
        }
	// set the velocity of x cordinate.
	public void setVelocityX(double aVelocityX) {
            this.velocityX = aVelocityX;
        }
	// get the velocity of y cordinate.
	public double getVelocityY() {
            return this.velocityY;
        }
	// set the velocity of y cordinate.
	public void setVelocityY(double aVelocityY) {
            this.velocityY = aVelocityY;
        }
}
>>>>>>> Data Package-Version 0.0.1
