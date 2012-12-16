package Data;

//has two arrays which keep names and high scores respectively.
public class HighScoreList {

	private ArrayList<Integer> highScores;
	private ArrayList<String> names;

	//takes the users name and high score and writes to arrays.
	public void addScore(int score, string name)
	{
	int place;
        if(score > highScores.get(9))
        {
            for(int i=0 ; i< 10 ; i++)
            {
                if ( highScores.get(i) < score )
                {
                    place = i;
                    highScores.add(i , score);
                    i++;
                    break;
                }
            }
            names.add(place , name );
            highScores.remove(10);
            names.remove(10);
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
