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
        
    }
    
    // get the players score
    public int getLastScore() {
        return 15;
    }

    // submits player's name with his score
    public void submitLastScore(String name) throws IOException {
        HighScoreList tempList = highScoreList;
        //If the player's score lower than 10.th point, there will be no submit.
        int k = tempList.getHighScoreNames().size();
        if (tempList.getHighPoints().size() == 10 && tempList.getHighPoints().get(0) > getLastScore() ) {
            return;
        } 
        else {
            for(int i = 0; i < tempList.getHighPoints().size() ; i++) {
                if(tempList.getHighPoints().get(i) < getLastScore()) {
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