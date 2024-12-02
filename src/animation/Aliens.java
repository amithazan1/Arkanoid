package animation;

import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Polygon;

/**
 * background of level 4.
 */
public class Aliens implements Sprite {
   private int[] stars1;
   private int[] stars2;

    /**
     * constructor.
     */
    public Aliens() {
        this.stars1 = Moon.randomLocations();
        this.stars2 = Moon.randomLocations();
    }

    /**
     * draw the background of level 4.
     *
     * @param d - the panel.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(14, 6, 39));
        d.fillRectangle(0, 0, 800, 600);
        Moon.drawStars(d, stars1, Color.WHITE);
        Moon.drawStars(d, stars2, new Color(214, 175, 237));
        drawPlanets(d);
        drawAlien(d);

    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

    /**
     * draw planets on the panel.
     * @param d - the phanel.
     */
    public static void drawPlanets(DrawSurface d) {
        d.setColor(new Color(0x5AD9C0));
        d.fillCircle(90, 140, 20);
        d.setColor(new Color(0xCEB62A));
        d.drawOval(60, 140, 60, 10);
        d.setColor(new Color(0x8D2A57));
        d.fillCircle(500, 470, 30);
        d.setColor(new Color(0xE289E8));
        d.drawOval(455, 470, 90, 10);
        d.setColor(new Color(0x1D1DAF));
        d.fillCircle(500, 70, 20);
        d.setColor(new Color(0x0EE839));
        d.drawOval(470, 70, 60, 10);
        d.setColor(new Color(0x832BCC));
        d.fillCircle(600, 200, 30);
        d.setColor(new Color(0xEE852F));
        d.drawOval(560, 200, 80, 10);
        d.setColor(new Color(0xE722D7));
        d.fillCircle(200, 200, 30);
        d.setColor(new Color(0xEEDE2F));
        d.drawOval(160, 200, 80, 10);
        d.setColor(new Color(0xEE92B6));
        d.fillCircle(300, 400, 30);
        d.setColor(new Color(0x9EE0E8));
        d.drawOval(260, 400, 80, 10);
        d.setColor(new Color(0x8CD2F8));
        d.fillCircle(700, 470, 20);
        d.setColor(new Color(0xD20AE5));
        d.drawOval(670, 470, 60, 10);
        d.setColor(new Color(0xCE3244));
        d.fillCircle(400, 300, 25);
        d.setColor(new Color(0x6ADA8E));
        d.drawOval(365, 300, 70, 10);
    }
    private void drawAlien(DrawSurface d) {
        // x coordinates of vertices.
        int[] x1 = {220, 240, 260};
        int[] x2 = {180, 160, 140};
        // y coordinates of vertices.
        int[] y1 = {320, 270, 320};
        int[] y2 = {320, 270, 320};
        d.setColor(new Color(0xCACAD5));
        d.fillPolygon(new Polygon(x1, y1, 3));
        d.fillPolygon(new Polygon(x2, y2, 3));
        d.setColor(new Color(0xA1A1AB));
        d.drawPolygon(new Polygon(x1, y1, 3));
        d.drawPolygon(new Polygon(x2, y2, 3));
        d.setColor(Color.WHITE);
        d.drawCircle(200, 400, 100);
        d.setColor(new Color(0x68E140));
        d.drawLine(290, 400, 340, 450);
        d.drawLine(291, 400, 341, 450);
        d.drawLine(292, 400, 342, 450);
        d.drawLine(100, 400, 60, 450);
        d.drawLine(101, 400, 61, 450);
        d.drawLine(102, 400, 62, 450);
        d.fillCircle(200, 400, 100);
        d.fillOval(160, 480, 20, 80);
        d.fillOval(220, 480, 20, 80);
        d.setColor(Color.WHITE);
        d.fillCircle(200, 390, 50);
        d.setColor(Color.BLACK);
        d.fillCircle(190, 400, 30);
        d.setColor(Color.WHITE);
        d.fillCircle(190, 400, 10);
        d.setColor(new Color(0x055D14));
        d.fillRectangle(175, 470, 50, 5);
    }
}
