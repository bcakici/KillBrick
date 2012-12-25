/* holds and controls GameView, HighScoreView, HelpView, AboutUsView and MainMenu.
* this class is designed like singleton pattern because there must be only one instance
* of it */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ViewController extends javax.swing.JFrame{
    
    // Properties of the frame
    private boolean mute;
    private String playerName;
    private GameView gameView;
    private HighScoreView highScoreView;
    private HelpView helpView;
    private AboutUsView aboutUsView;
    private MainMenu mainMenu;
    private static ViewController viewController;
    private JOptionPane showEnterNamePanel;
    
    /**
     * Creates new form ViewController
     */
    
	// creates view objects
	// gets the instance of viewcontroller if there is no instance create new viewcontroller
    public static ViewController getInstance(){
        if(viewController == null) {
            viewController = new ViewController();
        }
        return viewController;    
    }
    
    private ViewController() {
        initComponents();
        this.setTitle("Kill Brick");
        
        
        gameView = new GameView();
        this.add(gameView);
        
        highScoreView = new HighScoreView();
        this.add(highScoreView);
        
        helpView = new HelpView();
        this.add(helpView);
        
        aboutUsView = new AboutUsView();
        this.add(aboutUsView);
        
        mainMenu = new MainMenu();
        this.add(mainMenu);
        this.showMainMenu();
    }
    
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
    
    // displays main menu
    public void showMainMenu() {
        setContentPane(mainMenu);
        mainMenu.setVisible(true);
    }
    // it shows high score list
    public void showHighScoreView() {
        setContentPane(highScoreView);
        highScoreView.setVisible(true);
    }
    //gives information about how to play game.
    public void showHelpView() {
        setContentPane(helpView);
        helpView.setVisible(true);
    }
    // gives information about developers
    public void showAboutUsView() {
        setContentPane(aboutUsView);
        aboutUsView.setVisible(true);
    }
    
    // set the mute option.
    public void setMute(boolean mute) {
        this.mute = mute;
    }
    // get the mute option.
    public boolean getMute() {
        return mute;
    }
    
    // at the end of the game if the player is in top ten the name of the user is displayed on this screen
    public void showEnterNamePanel() {
        do{
            playerName = showEnterNamePanel.showInputDialog("Enter your name : ");
        }while (playerName == null);
    }

    // get the name from label.
    public String getName() {
        return playerName;   
    }

    // set's player's name
    public void setName(String name) {
        playerName = name;
    }
    
    // it close the game.
    public void finishGame() { 
        gameView.setVisible(false);
        setContentPane(mainMenu);
        mainMenu.setVisible(true);
    }
    
    public void refresh() {

    }

    //starts multiplayer game
    public void startMultiplayerGame(boolean mute) {
        setContentPane(gameView);
        gameView.setVisible(true);
        gameView.createGameEngine(true, mute);
    }

    //starts single player game
    public void startSingleplayerGame(boolean mute) {
        setContentPane(gameView);
        gameView.setVisible(true);
        gameView.createGameEngine(false, mute);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        middlePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(upperPanel, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout middlePanelLayout = new javax.swing.GroupLayout(middlePanel);
        middlePanel.setLayout(middlePanelLayout);
        middlePanelLayout.setHorizontalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        middlePanelLayout.setVerticalGroup(
            middlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewController().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel middlePanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
}
