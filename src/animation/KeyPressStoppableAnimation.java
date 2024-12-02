package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * decorator pattern.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
    }

    /**
     * in charge of the logic.
     *
     * @param d - the surface.
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (key == "space") {
            if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY) && !isAlreadyPressed) {
                animation.setStop(true);
            } else {
                isAlreadyPressed = false;
            }
        }

    }

    /**
     * In charge of stopping condition.
     *
     * @return true - when should stop, false- otherwise.
     */
    public boolean shouldStop() {
        return animation.shouldStop();
    }

    /**
     * setter.
     *
     * @param stop -.
     */
    public void setStop(boolean stop) {
        return;
    }
}
