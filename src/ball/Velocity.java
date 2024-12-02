//318900545 Amit Hazan.
package ball;

import BasicShapes.Point;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     *
     * @param dx - steps on the x axe.
     * @param dy - steps on the y axe.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getter.
     *
     * @return steps on the x axe.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getter.
     *
     * @return - steps on the y axe.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * setter.
     *
     * @param dx - steps on the x axe.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * setter.
     *
     * @param dy - steps on the x axe.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p - Point object.
     * @return - a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        Point movedP = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return movedP;
    }

    /**
     * Determines the direction in which the ball will move by an angle, and speed.
     *
     * @param angle - Direction, 0 is up.
     * @param speed - the speed that the ball will move.
     * @return - the velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = sin(Math.toRadians(angle)) * speed;
        double dy = -cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
}
