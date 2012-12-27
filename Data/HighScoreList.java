
package Data;
//has two arrays which keep names and high scores respectively.
import java.io.*;
import java.util.ArrayList;

public class HighScoreList {
    
    private String path = "HighScores.txt";
    private ArrayList<Integer> pointsList;
    private ArrayList<String> namesList;
    //takes the users name and high score and writes to arrays.
    
    public HighScoreList() {
        pointsList = new ArrayList<Integer>();
        namesList = new ArrayList<String>();
        File file = new File(path);
        if(!file.exists()) {
            try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    public void addScore(int score, String name, int position) throws IOException {
        
        pointsList = getHighScorePoints();
        namesList = getHighScoreNames();
        FileWriter fileW = new FileWriter(path,false);
        BufferedWriter writer = new BufferedWriter(fileW);
        
        int i = 0;
        while(i != position) {       
            writer.write(namesList.get(i) + " *" + pointsList.get(i));
            writer.newLine();
            i++;
        }
        writer.write(name + " *" + score);
        writer.newLine();
        while (i != pointsList.size()) {
            writer.write(namesList.get(i) + " *" + pointsList.get(i));
            writer.newLine();
            i ++;
        }
        writer.close(); 
    }
    
    // get the highscores from array.
    public ArrayList<Integer> getHighScorePoints() throws IOException{
        if(pointsList.isEmpty() == false) {
            return pointsList;
        }
        
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        String line;
        while((line = reader.readLine()) != null) {

            // In the .txt file, the scores are recorded with '-'. Example : Utku - 23. We should omit the inception of the string.
            int index = line.indexOf('*');
            line = line.substring(index +1);
            line.trim(); // We need only numbers.
            int sc = Integer.parseInt(line);
            pointsList.add(sc);
        }
        reader.close();
        return pointsList;
    }
    
    // get the highscores name from array.
    public ArrayList<String> getHighScoreNames() throws IOException {
        
        if(namesList.isEmpty() == false) {
            return namesList;
        }
        
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        String line;
        while((line = reader.readLine()) != null) {
            // In the .txt file, the scores are recorded with '-'. Example : Utku *23. We should omit the rest of the string.
            int index = line.indexOf('*');
            if (index > 0) {
                line = line.substring(0, index - 1);
                namesList.add(line);
            }
        }
        reader.close();
        return namesList;
    }

}
