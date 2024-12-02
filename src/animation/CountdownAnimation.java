package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen, for numOfSeconds seconds,
 * and on top of them it will show a countdown. countFrom back to 1,
 * where each number will appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private int countFrom;
    private final SpriteCollection gameScreen;

    /**
     * constructor.
     *
     * @param numOfSeconds - num of second the animation is shown.
     * @param countFrom    - the number we start count from back to 1.
     * @param gameScreen   - the given game screen of the level.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = (numOfSeconds / countFrom) * 1000;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    /**
     * display the countdown.
     *
     * @param d - the surface.
     */
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        if (this.countFrom == 0) {
            d.drawText(400, 300, "Go", 50);
        } else {
            d.drawText(400, 300, Integer.toString(countFrom), 30);
        }
        this.countFrom -= 1;
    }

    /**
     * in charge of the stopping condition.
     *
     * @return true - when should stop, false- otherwise.
     */
    public boolean shouldStop() {
        Sleeper sleeper = new Sleeper();
        if (this.countFrom != 3) {
            sleeper.sleepFor((int) numOfSeconds);
        }
        return (this.countFrom == -1);
    }
    /**
     * setter.
     * @param stop -.
     */
    public void setStop(boolean stop) {
        return;
    }
}

