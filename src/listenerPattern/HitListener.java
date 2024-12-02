//318900545 Amit Hazan.
package listenerPattern;

import ball.Ball;
import collidableObjects.Block;

/**
 * Objects that want to be notified of hit events, should implement the HitListener interface,
 * and register themselves with a HitNotifier object using its addHitListener method.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit - collidable object.
     * @param hitter   - The hitter parameter is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}


