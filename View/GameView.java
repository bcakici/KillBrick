//-	keeps the GameObject
package View;

import java.awt.*;
import javax.swing.JPanel;

public class GameView extends JPanel {
	// keeps the option of single or multi player game.
	// creates GameEngine object
	public GameView() {
		setLayout(null);
	}

	Logic.GameEngine gameEngine;

	public void createGameEngine(boolean isMultiplayer, boolean sound) {

		if (isMultiplayer == true) {
			gameEngine = new Logic.GameEngine(this, true);
		} else {
			gameEngine = new Logic.GameEngine(this, false);
		}
	}

	// exits game.
	public void exitGame() {
		ViewController.getInstance().hideAllPanels();
		ViewController.getInstance().setDefaultCloseOperation(
				ViewController.getInstance().EXIT_ON_CLOSE);
	}


}
