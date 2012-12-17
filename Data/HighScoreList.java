package Data;

import java.util.ArrayList;

//has two arrays which keep names and high scores respectively.
public class HighScoreList {

	private ArrayList<Integer> highScores;
	private ArrayList<String> names;

	//takes the users name and high score and writes to arrays.
	public void addScore(int score, String name) {
		if (score > highScores.get(9)) {
			for (int i = 0; i < 10; i++) {
				if (highScores.get(i) < score) {
					highScores.add(i, score);
					names.add(i, name);
					highScores.remove(10);
					names.remove(10);
					break;
				}
			}
		}
	}

	// get the highscores from array.
	public ArrayList<Integer> getHighScores()
	{
        return highScores;
	}

	// get the highscores name from array.
	public ArrayList<String> getHighScoreNames()
	{
        return names;
	}

}
