
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
        File file = new File(path);
        if(!file.exists()) {
            try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        pointsList = getHighScorePoints();
        namesList = getHighScoreNames();
    }

    public void addScore(int score, String name, int position){
        
        FileWriter fileW;
		try {
			fileW = new FileWriter(path,false);
		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // get the highscores from array.
    public ArrayList<Integer> getHighScorePoints(){
        pointsList = new ArrayList<Integer>();
        FileReader file;
		try {
			file = new FileReader(path);
		
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
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return pointsList;
    }
    
    // get the highscores name from array.
    public ArrayList<String> getHighScoreNames(){
        namesList = new ArrayList<String>();
        
        FileReader file;
		try {
			file = new FileReader(path);
		
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namesList;
    }

}
