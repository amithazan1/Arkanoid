//318900545 Amit Hazan.
package collidableObjects;

import BasicShapes.Point;

/**
 * Information about the collision of the ball.
 */
public class CollisionInfo {
    private final Point collisionPoint;
    private final Collidable collisionObject;

    /**
     * constructor.
     *
     * @param p      - collision point.
     * @param object - collision object.
     */
    public CollisionInfo(Point p, Collidable object) {
        this.collisionPoint = p;
        this.collisionObject = object;
    }

    /**
     * getter.
     *
     * @return - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * getter.
     *
     * @return - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
