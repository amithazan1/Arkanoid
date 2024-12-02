package animation;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * background of level 2.
 */
public class SpaceShip implements Sprite {
    private final int[] stars1;
    private final int[] stars2;
    private final int[] stars3;
    private final int[] stars4;

    /**
     * constructor.
     */
    public SpaceShip() {
        this.stars1 = Moon.randomLocations();
        this.stars2 = Moon.randomLocations();
        this.stars3 = Moon.randomLocations();
        this.stars4 = Moon.randomLocations();
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(14, 6, 39));
        d.fillRectangle(0, 0, 800, 600);
        Moon.drawStars(d, stars1, Color.WHITE);
        Moon.drawStars(d, stars2, new Color(214, 175, 237));
        Moon.drawStars(d, stars3, new Color(172, 2, 212));
        Moon.drawStars(d, stars4, new Color(239, 213, 240));
        drawSpaceShip(d);
    }

    @Override
    public void timePassed() {

    }

    /**
     * draw Space Ship.
     *
     * @param d - the panel.
     */
    public void drawSpaceShip(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawCircle(400, 50, 10);
        d.setColor(new Color(0xF5F045));
        d.fillCircle(400, 70, 10);
        d.drawLine(400, 70, 400, 170);
        d.setColor(new Color(0x0EE839));
        d.drawLine(300, 190, 200, 270);
        d.drawLine(400, 190, 400, 300);
        d.drawLine(500, 190, 600, 270);
        d.setColor(new Color(0x1C5904));
        d.fillCircle(200, 270, 5);
        d.fillCircle(400, 300, 5);
        d.fillCircle(600, 270, 5);
        d.setColor(new Color(0xD73448));
        d.fillOval(200, 175, 400, 75);
        d.setColor(Color.WHITE);
        d.drawOval(200, 175, 400, 75);
        d.setColor(new Color(0x050536));
        d.drawCircle(400, 170, 60);
        d.setColor(new Color(0x9EE0E8));
        d.fillCircle(400, 170, 60);
        d.setColor(new Color(0xB21C4A));
        d.drawOval(250, 185, 300, 50);
        d.setColor(new Color(0xBE2420));
        d.fillOval(250, 185, 300, 50);
    }
}
