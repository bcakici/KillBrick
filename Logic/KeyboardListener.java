package Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* listens keyboard inputs and returns last keyboard input */
public class KeyboardListener implements KeyListener {
	private GameEngine gameEngine;
	private int pressedKey;

	public KeyboardListener(GameEngine e) {
		this.gameEngine = e;
	}

	// it gets last button is pressed by user.
	public int getPressed() {
		return 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressed = e.getKeyLocation();
		gameEngine.createLevel(1);
		if (pressed == KeyEvent.KEY_LOCATION_LEFT) {
			gameEngine.getPedal1().moveLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println( "asda");

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println( "asda");

	}
}
