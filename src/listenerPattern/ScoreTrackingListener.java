//318900545 Amit Hazan.
package listenerPattern;

import ball.Ball;
import collidableObjects.Block;

/**
 * update the score when blocks are being hit and removed :hitting a block is worth 5 points.
 * Cleaning an entire level (destroying all blocks) is worth another 100 points.
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter - score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * adding 5 points to the score when hitting accure.
     *
     * @param beingHit - collidable object.
     * @param hitter   - The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
