package Logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		else if (pressed == KeyEvent.VK_A) {
			gameEngine.getPedal2().moveLeft();
		}
		else if (pressed == KeyEvent.VK_D) {
			gameEngine.getPedal2().moveRight();
		}
		else if (pressed == KeyEvent.VK_SPACE) {
			gameEngine.getPedal1().freeBall();
		}
		gameEngine.stopPedalsIfCollide();
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
		else if (pressed == KeyEvent.VK_A) {
			gameEngine.getPedal2().stop();
		}
		else if (pressed == KeyEvent.VK_D) {
			gameEngine.getPedal2().stop();
		}

	}
}
