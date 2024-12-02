//318900545 Amit Hazan.
package animation;

import biuoop.DrawSurface;
import listenerPattern.Counter;

import java.awt.Color;

/**
 * in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private final Counter score;
    private final String levelName;

    /**
     * constructor.
     *
     * @param score     - a reference to the score member in Game class.
     * @param levelName - the name of the current level.
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
    }

    /**
     * draw the score to the screen.
     *
     * @param d - the panel.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(33, 2, 61));
        d.fillRectangle(0, 0, 800, 30);
        d.setColor(new Color(129, 5, 245));
        d.drawRectangle(0, 0, 800, 30);
        d.setColor(new Color(230, 7, 174));
        d.drawText(300, 20, "Score:" + score.getValue(), 20);
        d.drawText(600, 20, "Level: " + this.levelName, 20);
    }

    /**
     * does nothing.
     */
    public void timePassed() {
        return;
    }
}
