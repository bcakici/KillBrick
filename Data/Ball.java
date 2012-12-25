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
}

