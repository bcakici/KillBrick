//-	keeps the GameObject
package View;

import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.GameObject;
import Logic.GameLogic;
import Logic.HighScoreManager;

public class GameView extends JPanel {
	// keeps the option of single or multi player game.
	// creates GameEngine object

	Logic.GameLogic gameLogic;
	JLabel score, lives;
	
	public GameView() {
		setLayout( null);
		addHud();
		gameLogic = new GameLogic();
	}
	private void addHud(){

		score = new JLabel("Score : 0");
		score.setVisible( true);
		score.setBounds( 700, 5, 100, 50);
        score.setFont(new java.awt.Font("Tahoma", 0, 16));
        
		lives = new JLabel("Lives : 0");
		lives.setVisible( true);
		lives.setBounds( 15, 5, 100, 50);
        lives.setFont(new java.awt.Font("Tahoma", 0, 16));
		add( lives);
		add( score);
	}
	@Override
	public void removeAll() {
		super.removeAll();
		addHud();
	}

	public void setScoreText( int s){
		score.setText("Score : " + s);
	}
	public void setLivesText( int l){
		lives.setText("Lives : " + l);
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
