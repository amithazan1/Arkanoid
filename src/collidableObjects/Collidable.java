//318900545 Amit Hazan.
package collidableObjects;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import ball.Ball;
import ball.Velocity;

/**
 * The Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {
    /**
     * @return - the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          - the ball that's doing the hitting.
     * @param collisionPoint  - collision point with an object.
     * @param currentVelocity - current velocity of the ball.
     * @return - the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
