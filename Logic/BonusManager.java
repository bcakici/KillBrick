package Logic;

import java.util.ArrayList;

import View.GameView;

import Data.*;

public class BonusManager {

	private ArrayList<Bonus> bonuses;
	public BonusManager() {
		bonuses = new ArrayList<Bonus>();
	}
	public void makeBonusCollisionsWith( Pedal pedal, GameLogic gl){
		for (Bonus bonus : bonuses) {
			Point collision = bonus.getCollision(pedal);
			if( collision == null){
				collision = pedal.getCollision( bonus);
			}
			if (collision != null) {
				bonus.gainBonus(gl, pedal);
				gl.gameView.remove(bonus);
				gl.gameView.repaint();
				gl.highScoreManager.addScoreToCurrentGame( bonus.getScore());
				gl.gameView.setScoreText( gl.highScoreManager.getLastScore());
				bonuses.remove( bonus);
				break;
			} 
		}
	}

	public void handleFalls(GameView gv) {
		for( Bonus bonus : bonuses){
			if( bonus.getPosition().getY()>620){
				gv.remove( bonus);
				bonuses.remove(bonus);
				break;
			}
		}
	}
	public Bonus createRandomBonus( Brick brick, GameView gv) {
		Bonus bonus;
		switch (0){//(int) (Math.random() * 14)) {
		case 0:
			bonus = new BallBonus();
			break;
		case 1:
			bonus = new LifeBonus();
			break;
		case 2:
			bonus = new PedalLengthBonus();
			break;
		case 3:
			bonus = new ScoreBonus();
			break;
		case 4:
			bonus = new SpeedBonus();
			break;
		default:
			bonus = null;
			break;
		}
		if (bonus != null) {
			brick.setBonus(bonus);
			gv.add( bonus);
			bonuses.add(bonus);
		}
		return bonus;
	}
	public void removeBonuses() {
		bonuses.clear();
	}
	public void removeFallingBonuses( GameView gv){
		for( int i = 0; i < bonuses.size(); i++){
			Bonus bonus = bonuses.get(i);
			if( bonus.isVisible()){
				gv.remove( bonus);
				gv.repaint();
				bonuses.remove( bonus);
				i--;
			}
		}
	}
	public void moveBonuses(double elapsedTime) {
		for (Bonus bonus : bonuses) {
			bonus.move( elapsedTime);
		}
	}

}
