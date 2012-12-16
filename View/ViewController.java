
package View;
import java.awt.*;

/* holds and controls GameView, HighScoreView, HelpView, AboutUsView and MainMenu.
* this class is designed like singleton pattern because there must be only one instance
* of it */
public class ViewController {
    
	private boolean mute;
	private String name;
	private GameView gameView;
	private HighScoreView highScoreView;
	private HelpView helpView;
	private AboutUsView aboutUsView;
	private MainMenu mainMenu;
	private static ViewController viewController;
	// creates view objects
	private ViewController(){}
	// gets the instance of viewcontroller if there is no instance create new viewcontroller
	public static ViewController getInstance(){
            if(viewController == null) {
                viewController = new ViewController();
            }
            return viewController;    
        }
        
	// displays main menu
	public void showMainMenu() {
            
            
        }
	// it hide all views that are visible  
	public void hideAllPanels() {
            if(mainMenu.isVisible() == true) {
                mainMenu.setVisible(false);
            }
            if(aboutUsView.isVisible() == true) {
                aboutUsView.setVisible(false);
            }
            if(helpView.isVisible() == true) {
                helpView.setVisible(false);
            }
            if(highScoreView.isVisible() == true) {
                highScoreView.setVisible(false);
            } 
        }
	// it shows high score list
	public void showHighScoreView() {}
	//gives information about how to play game.
	public void showHelpView() {}
	// gives information about developers
	public void showAboutUsView() {}
	// set the mute option.
	public void setMute(boolean mute) {}
	// get the mute option.
	public boolean getMute() {}
	// it refresh the all panel and layer. 
	public void refresh() {}
	// at the end of the game if the player is in top ten the name of the user is displayed on this screen
	public void showEnterNamePanel() {}
	// get the name from label.
	public String getName() {	}
	// set's player's name
	public void setName(String name) {}
	//starts multiplayer game
	public void startMultiplayerGame(boolean mute) {}
	//starts single player game
	public void startSingleplayerGame(boolean mute) {}
	// it close the game.
	public void finishGame() { }
}