package Logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* listens keyboard inputs and returns last keyboard input */
public class KeyboardListener extends KeyAdapter {
	private GameEngine gameEngine;

	public KeyboardListener(GameEngine e) {
		this.gameEngine = e;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressed = e.getKeyCode();
		if (pressed == KeyEvent.VK_LEFT) {
			gameEngine.getPedal1().moveLeft();
		}
		else if (pressed == KeyEvent.VK_RIGHT) {
			gameEngine.getPedal1().moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressed = e.getKeyCode();
		if (pressed == KeyEvent.VK_LEFT) {
			gameEngine.getPedal1().stop();
		}
		else if (pressed == KeyEvent.VK_RIGHT) {
			gameEngine.getPedal1().stop();
		}

	}
}
