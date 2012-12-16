package Data;

// wall is the object around the screen. 
// it keeps wall height and width.
public class Wall extends GameObject {
	private int height;
	private int width;
	// Get the wall height. 
	public int getHeight() {}
	// set the hight. 
	public void setHeight(int height) {}
	// get the width of wall.
	public int getWidth() {}
	// set the width. 
	public void setWidth(int width) {}
	/* this method redraws game object this method is implemented by every gameobject itself
	*  if it is a ball draws ball, if it is brick draws brick and so on */
	public void redraw() {}

}