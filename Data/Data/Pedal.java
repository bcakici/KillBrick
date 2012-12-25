package Data;

//draws the pedal and keeps its length.
public class Pedal extends GameObject {

    public Pedal() {
		super("");
		// TODO Auto-generated constructor stub
	}

	//declares variable for the distance to travel each time in pixels
    private int move = 5;

    //declares variables for x and y coordinates
    private int x, y;

    private int min = 0, max = 1000, width = 100, height = 20;

    //constructor that takes in x and y coordinates for pedal
    


    // moves the pedal left.
    public void moveLeft() {
        if (this.x - this.move > this.min) {
            this.x -= this.move;
        } else {
            this.x = this.move;
        }
    }
    // moves the pedal right.

    public void moveRight() {
        if (this.x - this.move > this.min) {
            this.x += this.move;
        } else {
            this.x = this.move;
        }
    }
    /*
     * this method redraws game object this method is implemented by every
     * gameobject itself if it is a ball draws ball, if it is brick draws brick
     * and so on
     */

    public void redraw() {
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }


}
