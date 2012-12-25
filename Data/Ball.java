//this class corresponds to ball in game
public class Ball extends GameObject {
	public BallManager;
	// calculate the reflect ball form
	public void reflectFrom(Point Collision) {}
	// free the ball from pedal.
	public void free() {}
	// attach to ball to pedal.
	public void attachTo(Pedal p) {}
	/* redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

	//coordinates
    int x,y;

    //velocities
     int dx, dy;

     //Singleton instance
    private static Ball ball = null;

    //private constructor
    private Ball(int x, int y){

        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;

    }

    //instantiates instance if there isn't already one
    public static Ball getBall(int x, int y){
        if(ball == null){
            ball = new Ball(x, y);

        }
        return ball;
    }

    //gets x velocity of the ball
    public int getXVelocity() {
        return dx;
    }

    //sets x velocity of ball
    public void setXVelocity(int dx) {
        this.dx = dx;
    }

    //gets y velocity of ball
    public int getYVelocity() {
        return dy;
    }

    //sets y velocity of ball
    public void setYVelocity(int dy) {
        this.dy = dy;
    }

    //gets x-coordinate of ball
    public int getX() {
        return x;
    }

    //sets x-coordinate of ball
    public void setX(int x) {
        this.x = x;
    }

    //gets y-coordinate of ball
    public int getY() {
        return y;
    }

    //sets y-coordinate of ball
    public void setY(int y) {
        this.y = y;
    }
}

