//318900545 Amit Hazan.
package BasicShapes;

import java.util.ArrayList;

/**
 * Represents a rectangle on the axes.
 */
public class Rectangle {
    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * constructor.
     * Create a new rectangle with location width and height.
     *
     * @param upperLeft
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
    }

    /**
     * Checks the intersection points between a given line and a rectangle.
     *
     * @param line - Line object.
     * @return - Return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersectionList = new ArrayList<Point>();
        Line[] recLines = new Line[4];
        Point upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        Point bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);
        Point bottomRight = new Point(upperRight.getX(), upperRight.getY() + this.height);
        recLines[0] = new Line(upperLeft, upperRight);
        recLines[1] = new Line(upperLeft, bottomLeft);
        recLines[2] = new Line(bottomLeft, bottomRight);
        recLines[3] = new Line(bottomRight, upperRight);
        for (Line recLine : recLines) {
            if (recLine.intersectionWith(line) == null) {
                continue;
            } else {
                intersectionList.add(recLine.intersectionWith(line));
            }
        }
        return intersectionList;
    }

    /**
     * getter.
     *
     * @return - Return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getter.
     *
     * @return - Return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getter.
     *
     * @return - Returns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}

