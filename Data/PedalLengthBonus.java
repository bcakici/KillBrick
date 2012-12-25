package Data;

//can able to length or shorten the pedal.
public class PedalLengthBonus extends Bonus {

    private double lengthMultiplier;
    /*
     * this method redraws game object this method is implemented by every
     * gameobject itself if it is a ball draws ball, if it is brick draws brick
     * and so on
     */

    public void gainBonus(GameEngine e, Pedal p, BallManager b, HighScoreManager h) {
        p.setWidth((int)(p.getWidth()*1.5));
    }

    public void redraw() {
    }
}

