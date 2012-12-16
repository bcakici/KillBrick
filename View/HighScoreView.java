package View;
import java.awt.*;
import Logic.HighScoreManager;
import javax.swing.JPanel;

// this view class is a panel that shows top highscores
// submit of last highscore is happening through this class
// creates and holds HighScoreManager object
public class HighScoreView extends JPanel{
	private HighScoreManager manager;
	// it takes highscores from highscore manager and refreshes itself.
	public void updateScores() {}
	// it submit the current game's Score.
	public void submitLastScore(String name) {}
}