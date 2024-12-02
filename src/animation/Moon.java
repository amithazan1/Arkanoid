package animation;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.Random;

/**
 * background of level 1.
 */
public class Moon implements Sprite {
    private final int[] stars1;
    private final int[] stars2;
    private final int[] stars3;
    private final int[] stars4;

    /**
     * constructor.
     */
    public Moon() {
        this.stars1 = randomLocations();
        this.stars2 = randomLocations();
        this.stars3 = randomLocations();
        this.stars4 = randomLocations();
    }

    /**
     * draw the background.
     *
     * @param d - the panel.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(14, 6, 39));
        d.fillRectangle(0, 0, 800, 600);
        drawStars(d, stars1, Color.WHITE);
        drawStars(d, stars2, new Color(214, 175, 237));
        drawStars(d, stars3, new Color(172, 2, 212));
        drawStars(d, stars4, new Color(239, 213, 240));
        drawMoon(d);
    }

    @Override
    public void timePassed() {
        return;
    }

    /**
     * random locations.
     *
     * @return random locations.
     */
    public static int[] randomLocations() {
        Random rand = new Random();
        int[] arr = new int[120];
        for (int i = 0; i < 60; i++) {
            arr[i] = rand.nextInt(770) + 30;
            arr[i + 1] = rand.nextInt(540) + 30;
        }
        return arr;
    }

    /**
     * draw stars.
     *
     * @param d     - the panel.
     * @param arr   - locations.
     * @param color - color.
     */
    public static void drawStars(DrawSurface d, int[] arr, Color color) {
        for (int i = 0; i < 60; i++) {
            d.setColor(color);
            d.fillCircle(arr[i], arr[i + 1], 2);
        }
    }

    private void drawMoon(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(400, 300, 100);
        d.setColor(new Color(150, 143, 142));
        d.fillCircle(350, 240, 20);
        d.setColor(new Color(148, 130, 130));
        d.fillCircle(370, 360, 30);
        d.setColor(new Color(148, 130, 130));
        d.fillCircle(420, 300, 40);
        d.setColor(Color.YELLOW);
        d.drawLine(380, 150, 380, 200);
    }
}
