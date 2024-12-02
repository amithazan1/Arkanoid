package animation;

import biuoop.DrawSurface;

/**
 * In charge of the animation loop.
 */
public interface Animation {
    /**
     * in charge of the logic.
     *
     * @param d - the surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * In charge of stopping condition.
     * @return true - when should stop, false- otherwise.
     */
    boolean shouldStop();

    /**
     * setter.
     * @param stop -.
     */
    void setStop(boolean stop);
}
