package Data;
// it keeps velocity of dynamic objects.
public class Velocity {

	private double velocityX;
	private double velocityY;

	public Velocity(double velocityX , double velocityY)
	{
        this.velocityX = velocityX;
        this.velocityY = velocityY;
	}

	// get the velocity of x cordinate.
	public double getVelocityX()
	{
         return velocityX;
	}

	// set the velocity of x cordinate.
	public void setVelocityX(double velocityX)
	{
        this.velocityX = velocityX;
	}

	// get the velocity of y cordinate.
	public double getVelocityY()
	{
        return velocityY;
	}
	// set the velocity of y cordinate.
	public void setVelocityY(double velocityY)
	{
        this.velocityY = velocityY;
	}
}
