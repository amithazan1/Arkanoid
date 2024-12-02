//318900545 Amit Hazan.
package listenerPattern;

import ball.Ball;
import collidableObjects.Block;
import animation.GameLevel;


/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game            - Game objects.
     * @param remainingBlocks - the number of the blocks remained in the game.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Remove the block that being hit.
     *
     * @param beingHit - collidable object.
     * @param hitter   - The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);
    }
}

