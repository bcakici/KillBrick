package Logic;
import Data.HighScoreList;
/*manages highscore list object, holds current highscore of game 
 at the end of the game if the user was able to get
 a score which is in top ten it saves users name and score into highscorelist*/
public class HighScoreManager {
    private int currentGameScore;
    private HighScoreList highScoreList;
    private static HighScoreManager instance;

    private HighScoreManager() {
        highScoreList = new HighScoreList();
    }

    //returns high scores from list
    public HighScoreList getHighScoreList() {
        return highScoreList;
    }
    
    // adds the score to currently active game
    public void addScoreToCurrentGame(int score) {
        currentGameScore += score;
    }
    
    // get the players score
    public int getLastScore() {
        return currentGameScore;
    }

    // submits player's name with his score
    public void submitLastScore(String name){
        //If the player's score lower than 10.th point, there will be no submit.
    	boolean written = false;
        if (highScoreList.getHighScorePoints().size() < 10 || 
        	highScoreList.getHighScorePoints().get(10) < getLastScore() ) {
            for(int i = 0; i < highScoreList.getHighScorePoints().size() ; i++) {
                if(highScoreList.getHighScorePoints().get(i) < getLastScore()) {
                    highScoreList.addScore(getLastScore(), name, i);
                    written = true;
                    break;
                }
            }    
            if(!written){
            	highScoreList.addScore( getLastScore(), name, highScoreList.getHighScorePoints().size());
            }
        }   
    }

    // starts too keep score when the user starts new game.
    public void startNewScore() {
        currentGameScore = 0;
    }

	public static HighScoreManager getInstance() {
		if( instance == null){
			instance = new HighScoreManager();
		}
		return instance;
	}
}