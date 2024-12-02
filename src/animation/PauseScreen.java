package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * display a screen with the message "paused -- press space to continue" until a key is pressed.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * pause the game.
     *
     * @param k - keyboard that represent pause.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * display a screen with the message "paused -- press space to continue".
     *
     * @param d - the surface.
     */
    public void doOneFrame(DrawSurface d) {
        int[] stars1 = Moon.randomLocations();
        int[] stars2 = Moon.randomLocations();
        d.setColor(new Color(14, 6, 39));
        d.fillRectangle(0, 0, 800, 600);
        Moon.drawStars(d, stars1, Color.WHITE);
        Moon.drawStars(d, stars2, new Color(214, 175, 237));
        Aliens.drawPlanets(d);
        d.setColor(Color.WHITE);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * in charge of stopping condition.
     *
     * @return true - should stop, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * setter.
     *
     * @param stop -.
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
