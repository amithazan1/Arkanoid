package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import listenerPattern.Counter;

import java.awt.Color;

/**
 * Once the game is over (either the player died, or he managed to clear all the levels),
 * we will display the final score.
 * If the game ended with the player dying (i.e. all balls fall off the screen),
 * the end screen should display the message "Game Over. Your score is X" (X being the final score).
 * If the game ended by clearing all the levels, the screen should display "You Win! Your score is X".
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private Counter numOfBalls;
    private Counter numOfBlocks;

    /**
     * constructor.
     *
     * @param keyboard
     * @param score
     * @param numOfBalls
     * @param numOfBlocks
     */
    public EndScreen(KeyboardSensor keyboard, Counter score, Counter numOfBalls, Counter numOfBlocks) {
        this.keyboard = keyboard;
        this.stop = false;
        this.score = score;
        this.numOfBalls = numOfBalls;
        this.numOfBlocks = numOfBlocks;
    }

    /**
     * in charge of the logic.
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
        if (this.numOfBalls.getValue() == 0) {
            d.setColor(Color.WHITE);
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(),
                    32);
        } else if (this.numOfBlocks.getValue() == 0) {
            d.setColor(Color.WHITE);
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(),
                    32);
        }
    }

    /**
     * In charge of stopping condition.
     *
     * @return true - when should stop, false- otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * setter.
     * @param stop -.
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
