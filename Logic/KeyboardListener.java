package Logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Data.Pedal;

/* listens keyboard inputs and returns last keyboard input */
public class KeyboardListener extends KeyAdapter {
	private Pedal pedal1, pedal2;
	private GameEngine gameEngine;

	public KeyboardListener(Pedal p1, Pedal p2, GameEngine e) {
		pedal1 = p1;
		pedal2 = p2;
		gameEngine = e;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressed = e.getKeyCode();
		if (pressed == KeyEvent.VK_LEFT) {
			pedal1.moveLeft();
		}
		else if (pressed == KeyEvent.VK_RIGHT) {
			pedal1.moveRight();
		}
		else if (pressed == KeyEvent.VK_A) {
			pedal2.moveLeft();
		}
		else if (pressed == KeyEvent.VK_D) {
			pedal2.moveRight();
		}
		else if (pressed == KeyEvent.VK_SPACE) {
			pedal1.freeBall();
		}
		gameEngine.stopPedalsIfCollide();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressed = e.getKeyCode();
		if (pressed == KeyEvent.VK_LEFT) {
			pedal1.stop();
		}
		else if (pressed == KeyEvent.VK_RIGHT) {
			pedal1.stop();
		}
		else if (pressed == KeyEvent.VK_A) {
			pedal2.stop();
		}
		else if (pressed == KeyEvent.VK_D) {
			pedal2.stop();
		}

	}
}
