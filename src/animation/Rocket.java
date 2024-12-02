package animation;

import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;

/**
 * background of level 3.
 */
public class Rocket implements Sprite {
    private int[] stars1;
    private int[] stars2;

    /**
     * constructor.
     */
    public Rocket() {
        this.stars1 = Moon.randomLocations();
        this.stars2 = Moon.randomLocations();
    }
    /**
     * draw the sprite.
     *
     * @param d - the panel.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(14, 6, 39));
        d.fillRectangle(0, 0, 800, 600);
        Moon.drawStars(d, stars1, Color.WHITE);
        Moon.drawStars(d, stars2, new Color(214, 175, 237));
        Aliens.drawPlanets(d);
        drawRocket(d);
    }

    @Override
    public void timePassed() {
        return;

    }

    private static Color randomRed() {
        Random rand = new Random();
        int g = rand.nextInt(200);
        return new Color(255, g, 0);
    }

    private void drawRocket(DrawSurface d) {
        // x coordinates of vertices.
        int[] topX1 = {60, 140, 100};
        int[] fireX2 = {75, 50, 100, 150, 125};
        int[] fireX3 = {85, 60, 100, 140, 115};
        int[] sideX4 = {125, 155, 140};
        int[] sideX5 = {45, 75, 60};
        // y coordinates of vertices.
        int[] topY1 = {250, 250, 170};
        int[] fireY2 = {500, 550, 590, 550, 500};
        int[] fireY3 = {500, 550, 580, 550, 500};
        int[] sideY4 = {480, 480, 400};
        int[] sideY5 = {480, 480, 400};
        // number of vertices
        int numberofpoints1 = 3;
        int numberofpoints2 = 5;
        d.setColor(Color.RED);
        d.fillPolygon(new Polygon(sideX4, sideY4, numberofpoints1));
        d.fillPolygon(new Polygon(sideX5, sideY5, numberofpoints1));
        d.setColor(Color.WHITE);
        d.fillOval(50, 200, 100, 300);
        d.setColor(Color.BLACK);
        d.drawCircle(100, 300, 30);
        d.setColor(Color.GRAY);
        d.fillCircle(100, 300, 30);
        d.fillRectangle(75, 480, 50, 20);
        d.setColor(Color.BLACK);
        d.drawCircle(100, 300, 20);
        d.setColor(new Color(0, 196, 255));
        d.fillCircle(100, 300, 20);

        // create a polygon with given x, y coordinates
        d.setColor(Color.RED);
        d.fillPolygon(new Polygon(topX1, topY1, numberofpoints1));
        d.setColor(randomRed());
        d.fillPolygon(new Polygon(fireX2, fireY2, numberofpoints2));
        d.setColor(randomRed());
        d.fillPolygon(new Polygon(fireX3, fireY3, numberofpoints2));
    }
}
