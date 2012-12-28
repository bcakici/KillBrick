package Logic;

import View.GameView;

public class GameLogic {
	protected GameEngine gameEngine;
	protected BallManager ballManager;
	protected HighScoreManager highScoreManager;
	protected GameView gameView;

	public void createGameEngine(GameView gameView, boolean isMultiplayer,
			boolean isMute) {
		this.gameView = gameView;
		ballManager = new BallManager();
		highScoreManager = HighScoreManager.getInstance();
		gameEngine = new GameEngine(this, isMultiplayer, isMute);
	}

	public void changeBallSpeeds(double speedMultiplier) {
		ballManager.changeBallSpeeds( speedMultiplier);
	}

	public void addScoreToCurrentGame(int score) {
		highScoreManager.addScoreToCurrentGame( score);
	}

	public void increaseLives() {
		gameEngine.increaseLives();
	}

	public void addBalls(int ballsToBeAdded) {
		ballManager.addBalls( ballsToBeAdded, gameView);
		
	}
	
}
