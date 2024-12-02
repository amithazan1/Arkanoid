package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The AnimationRunner takes an Animation object and runs it.
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;
    private final Sleeper sleeper;

    /**
     * getter.
     *
     * @return gui member.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * constructor.
     *
     * @param gui - the window.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 60;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * start the animation loop.
     *
     * @param animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.getGui().getDrawSurface();
            animation.doOneFrame(d);
            this.getGui().show(d);
            //timing.
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}