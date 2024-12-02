//318900545 Amit Hazan.
package listenerPattern;

import ball.Ball;
import collidableObjects.Block;
import animation.GameLevel;

/**
 * in charge of removing balls, and updating an available-balls counter.
 */
public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBall;

    /**
     * constructor.
     *
     * @param game          - Game objects.
     * @param remainingBall - the number of the balls remained in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBall) {
        this.game = game;
        this.remainingBall = remainingBall;
    }

    /**
     * Remove the ball that hit the "death region".
     *
     * @param beingHit - collidable object.
     * @param hitter   - The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBall.decrease(1);

    }
}
