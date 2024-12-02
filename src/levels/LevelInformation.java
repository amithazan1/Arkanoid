package levels;

import BasicShapes.Point;
import animation.Sprite;
import ball.Velocity;
import collidableObjects.Block;

import java.util.List;

/**
 * specifies the information required to fully describe a level.
 */
public interface LevelInformation {
    /**
     * return the number of balls on the level.
     *
     * @return the number of balls on the level.
     */
    int numberOfBalls();

    /**
     * Note that initialBallVelocities().size() == numberOfBalls().
     *
     * @return List of the initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle speed.
     *
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * return the paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * return the init paddle location.
     *
     * @return the init paddle location.
     */
    Point paddleLocation();

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the blocks of the level.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blocks needs to be removed.
     */
    int numberOfBlocksToRemove();
}

