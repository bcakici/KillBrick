package Logic;

import Data.HighScoreList;

/*manages highscore list object, holds current highscore of game 
 at the end of the game if the user was able to get
 a score which is in top ten it saves users name and score into highscorelist*/
public class HighScoreManager {
	private int currentGameScore;
	private HighScoreList highScoreList;

	// returns high scores from list
	public HighScoreList getHighScoreList() {
		return highScoreList;
	}

	// adds the score to currently active game
	public void addScoreToCurrentGame(int score) {
	}

	// get the players score
	public int getLastScore() {
		return 0;
	}

	// submits player's name with his score
	public void submitLastScore(String name) {
	}

	// starts too keep score when the user starts new game.
	public void startNewScore() {
	}
}