package Logic;
import Data.HighScoreList;
import java.io.IOException;
/*manages highscore list object, holds current highscore of game 
 at the end of the game if the user was able to get
 a score which is in top ten it saves users name and score into highscorelist*/
public class HighScoreManager {
    private int currentGameScore;
    private HighScoreList highScoreList;

    public HighScoreManager() {
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
    public void submitLastScore(String name) throws IOException {
        HighScoreList tempList = highScoreList;
        //If the player's score lower than 10.th point, there will be no submit.
        if (tempList.getHighScorePoints().size() == 10 && tempList.getHighScorePoints().get(0) > getLastScore() ) {
            return;
        } 
        else {
            for(int i = 0; i < tempList.getHighScorePoints().size() ; i++) {
                if(tempList.getHighScorePoints().get(i) < getLastScore()) {
                    tempList.addScore(getLastScore(), name, i);
                    return;
                }
            }       
        }   
    }

    // starts too keep score when the user starts new game.
    public void startNewScore() {
        currentGameScore = 0;
    }
}