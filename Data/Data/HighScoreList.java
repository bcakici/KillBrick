
package Data;
import Logic.*;
//has two arrays which keep names and high scores respectively.
import java.io.*;
import java.util.ArrayList;

public class HighScoreList {

    private ArrayList<Integer> highScores;
    private ArrayList<String> names;
    //takes the users name and high score and writes to arrays.

    public void addScore(int score, String name) {
        boolean isThere = false;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("High Scores.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                isThere = true;
                String[] arr = strLine.split(", ");
                int sc = Integer.parseInt(arr[0]);
                String nm = arr[1];

                if (Integer.parseInt(strLine.split(" ")[0]) > score) {
                    this.highScores.add(sc);
                    this.names.add(nm);
                } else {
                    this.highScores.add(score);
                    this.names.add(name);
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        if (!isThere) {
            this.highScores.add(score);
            this.names.add(name);

        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("High Scores.txt"));
            for (int i = 0; i < this.highScores.size(); i++) {
                out.write(this.highScores.get(i) + ", " + this.names.get(i));
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
        }
    }
    // get the highscores from array.

    public ArrayList<Integer> getHighScores() {
        if (this.highScores.size() != 0) {
            return this.highScores;
        }
        boolean isThere = false;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("High Scores.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                isThere = true;
                String[] arr = strLine.split(", ");
                this.highScores.add(Integer.parseInt(strLine.split(", ")[0]));
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        if(!isThere)
            return null;
        return this.highScores;
    }
    // get the highscores name from array.

    public ArrayList<String> getHighScoreNames() {
        if (this.names.size() != 0) {
            return this.names;
        }
        boolean isThere = false;
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("High Scores.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                isThere = true;
                String[] arr = strLine.split(", ");
                this.names.add(strLine.split(", ")[1]);
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        if(!isThere)
            return null;
        return this.names;
    }

}

