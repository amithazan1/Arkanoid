//318900545 Amit Hazan.
package BasicShapes;

/**
 * Line represents a straight line on the axis using two points.
 */
public class Line {
    private final Point start;
    private final Point end;

    /**
     * constructor.
     *
     * @param start - starting point of the line.
     * @param end   - ending point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor.
     *
     * @param x1 - x value of start point.
     * @param y1 - y value of start point.
     * @param x2 - x value of end point.
     * @param y2 - y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.start = start;
        this.end = end;
    }

    /**
     * Calculates the length of the line.
     *
     * @return Return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Calculates the middle point of the line.
     *
     * @return Point object- the middle point of the line.
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point midP = new Point(midX, midY);
        return midP;
    }

    /**
     * getter.
     * Returns the start point of the line.
     *
     * @return Point object.
     */
    public Point start() {
        return this.start;
    }

    /**
     * getter.
     * Returns the end point of the line.
     *
     * @return Point object.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Calculates the slope of a line.
     *
     * @return the slope of the line.
     */
    private double slope() {
        if ((this.start().getX() - this.end().getX()) == 0) {
            return 180;
        }
        return (this.start().getY() - this.end().getY()) / (this.start().getX() - this.end().getX());
    }

    /**
     * Calculates the intercept of a line.
     *
     * @return the intercept.
     */
    private double intercept() {
        return this.start().getY() - (this.slope() * this.start().getX());
    }

    private double min(double x1, double x2) {
        if (x1 < x2) {
            return x1;
        }
        return x2;
    }

    private double max(double x1, double x2) {
        if (x1 > x2) {
            return x1;
        }
        return x2;
    }

    /**
     * checks is a Point is on the line.
     *
     * @param x - x value of a point.
     * @param y - y value of a point.
     * @return true if the point is on the line and false otherwise.
     */
    public boolean isOnLine(double x, double y) {
        if (min(this.start.getX(), this.end.getX()) > x || x > max(this.start.getX(), this.end.getX())) {
            return false;
        }
        return !(min(this.start.getY(), this.end.getY()) > y) && !(y > max(this.start.getY(), this.end.getY()));
    }

    private boolean isLineHaveSamePoint(Line other) {
        if (this.start().equals(other.end()) || this.end().equals(other.start())) {
            return true;
        }
        return this.start().equals(other.start()) || this.end().equals(other.end());
    }

    private boolean isLineOverlap(Line other) {
        double startX = this.start().getX();
        double startY = this.start().getY();
        double endX = this.end().getX();
        double endY = this.end().getY();
        if (!other.isOnLine(startX, startY) && !other.isOnLine(endX, endY)) {
            return false;
        }
        return this.isOnLine(startX, startY) || this.isOnLine(endX, endY);

    }

    private Point parallelToY(Line other) {
        double x = 0;
        double y = 0;
        if (other.slope() == 180 && other.slope() != this.slope()) {
            x = other.start.getX();
            y = this.slope() * x + this.intercept();
            return new Point(x, y);
        }

        if (this.slope() == 180 && other.slope() != slope()) {
            x = start.getX();
            y = other.slope() * x + (other.start().getY() - (other.slope() * other.start.getX()));
            return new Point(x, y);
        }
        return null;

    }


    /**
     * Checks if two lines intersect.
     *
     * @param other - Line object.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        double m1 = this.slope();
        double m2 = other.slope();
        double x, y;
        double b1 = this.intercept();
        double b2 = other.intercept();
        Point p = this.parallelToY(other);

        if (this.isLineHaveSamePoint(other)) {
            return true;
        }

        // in case one line parallel to y.
        if (p != null && other.isOnLine(p.getX(), p.getY()) && this.isOnLine(p.getX(), p.getY())) {
            return true;
        }
        // in case the lines are parallel to each other.
        if (m1 - m2 == 0) {
            if (b1 != b2) {
                return false;
            }
            return this.isLineOverlap(other);
        }

        // in other cases.
        x = (b2 - b1) / (m1 - m2);
        y = (m1 * x) + b1;
        return this.isOnLine(x, y) && other.isOnLine(x, y);
    }

    private Point sameSlope(Line other) {
        double minOther = min(other.start().getX(), other.end().getX());
        double maxOther = max(other.start().getX(), other.end().getX());
        double maxThis = max(this.start().getX(), this.end().getX());
        double minThis = min(this.start().getX(), this.end().getX());
        if (minOther == maxThis) {
            if (minOther == other.start().getX()) {
                return new Point(other.start().getX(), other.start().getY());
            } else {
                return new Point(other.end().getX(), other.end().getY());
            }
        }
        if (maxOther == minThis) {
            if (maxOther == other.end().getX()) {
                return new Point(other.end().getX(), other.end().getY());
            } else {
                return new Point(other.start().getX(), other.start().getY());
            }
        }
        return null;
    }


    /**
     * Calculates the intersection point.
     *
     * @param other - line object.
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other)) {
            return null;
        }

        if (this.equals(other)) {
            return null;
        }

        double m1 = this.slope();
        double m2 = other.slope();
        double b1 = this.intercept();
        double b2 = other.intercept();

        if (m1 == m2) {
            return this.sameSlope(other);
        }

        Point p = this.parallelToY(other);
        if (p != null && other.isOnLine(p.getX(), p.getY()) && this.isOnLine(p.getX(), p.getY())) {
            return p;
        }

        double x = (b2 - b1) / (m1 - m2);
        double y = (m1 * x) + b1;
        Point intersectP = new Point(x, y);
        return intersectP;
    }

    /**
     * checks if the two lines are equal.
     *
     * @param other - Line object.
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start().equals(other.end()) && other.start().equals(this.end)) {
            return true;
        }
        if (!this.start.equals(other.start())) {
            return false;
        }
        return this.end.equals(other.end());
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect - Rectangle Object.
     * @return return the closest intersection point to the start of the line or null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        double minDistance;
        Point closestPoint;
        java.util.List<Point> intersectionList = rect.intersectionPoints(this);
        if (intersectionList.size() == 0) {
            return null;
        }
        minDistance = intersectionList.get(0).distance(this.start);
        closestPoint = intersectionList.get(0);
        for (int i = 1; i < intersectionList.size(); i++) {
            if (intersectionList.get(i).distance(this.start) < minDistance) {
                minDistance = intersectionList.get(i).distance(this.start);
                closestPoint = intersectionList.get(i);
            }
        }
        return closestPoint;
    }


}
