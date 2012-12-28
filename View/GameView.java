//-	keeps the GameObject
package View;

import javax.swing.JPanel;

import Data.GameObject;
import Logic.GameLogic;

public class GameView extends JPanel {
	// keeps the option of single or multi player game.
	// creates GameEngine object

	Logic.GameLogic gameLogic;
	
	public GameView() {
		setLayout( null);
		gameLogic = new GameLogic();
	}

	public void add( GameObject o){
		add( o.getView());
	}
	public void remove( GameObject o){
		remove( o.getView());
	}

	public void createGameEngine(boolean isMultiplayer, boolean isMute) {
		gameLogic.createGameEngine( this, isMultiplayer, isMute);
	}

	public void closeAndShowHighScores() {
		ViewController.getInstance().showEnterNamePanel();
		ViewController.getInstance().showHighScoreView();
	}
}
