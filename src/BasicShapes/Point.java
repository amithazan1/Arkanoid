//318900545 Amit Hazan.
package BasicShapes;

/**
 * Point represents a point on the axes.
 */
public class Point {
    private double x;
    private double y;
    public static final double EPSILON = Math.pow(10, -10);

    /**
     * constructor.
     *
     * @param x - value to initialize the member x.
     * @param y - value to initialize the member y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * // Calculates the distance between 2 points.
     *
     * @param other Point object.
     * @return return the distance of this point to the other point.
     */
    public double distance(Point other) {
        double d1 = this.x - other.getX();
        double d2 = this.y - other.getY();
        return Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
    }

    /**
     * checks if the two points are equal.
     *
     * @param other - Point object.
     * @return return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if (Math.abs(this.x - other.getX()) > EPSILON) {
            return false;
        }
        return !(Math.abs(this.y - other.getY()) > EPSILON);
    }

    /**
     * getter.
     *
     * @return the x member of the object.
     */
    public double getX() {
        return this.x;
    }

    /**
     * getter.
     *
     * @return the x member of the object.
     */
    public double getY() {
        return this.y;
    }

    /**
     * setter.
     *
     * @param y - y value of a point.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * setter.
     *
     * @param x - x value of a point.
     */
    public void setX(double x) {
        this.x = x;
    }
}