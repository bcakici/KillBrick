package Logic;

import Data.HighScoreList;
import View.HighScoreView;
/*manages highscore list object, holds current highscore of game 
 at the end of the game if the user was able to get
 a score which is in top ten it saves users name and score into highscorelist*/
public class HighScoreManager {
	private int currentGameScore;
	private HighScoreList highScoreList;
	//returns high scores from list
	public HighScoreList getHighScoreList() {
	// adds the score to currently active game
	public void addScoreToCurrentGame(int score) {}
	// get the players score
	public int getLastScore() {}
	// submits player's name with his score
	public void submitLastScore(string name) {}
	// starts too keep score when the user starts new game.
	public void startNewScore() {}
}