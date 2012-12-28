package Data;

import java.util.Timer;
import java.util.TimerTask;

import Logic.*;

//accelerate or deaccelerate the ball speed.
public class SpeedBonus extends Bonus {
	public SpeedBonus() {
		super("images/bonus.png");
	}

	public SpeedBonus(double x, double y) {
		super("images/bonus.png");
	}

	private static double speedMultiplier = 2;
	private static Timer timer = new Timer();
	private static int secondsLeft;
	private static BallManager ballManager;

	TimerTask task = new TimerTask() {

		@Override
		public void run() {
			if (secondsLeft > 0) {
				secondsLeft--;
			} else if (secondsLeft == 0) {
				ballManager.changeBallSpeeds(1 / speedMultiplier);
				timer.cancel();
			}
		}
	};

	// every bonuses implement this method differently, each bonus call it
	// related methods.
	@Override
	public void gainBonus(GameLogic gl, Pedal p) {
		if (secondsLeft == 0) {
			gl.changeBallSpeeds(speedMultiplier);
			timer.schedule(task, 1000, 1000);
		}
		secondsLeft += 5;
	}

}
