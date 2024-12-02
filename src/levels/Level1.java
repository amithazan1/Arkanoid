package levels;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Moon;
import animation.Sprite;
import ball.Velocity;
import collidableObjects.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * Level 1 logic.
 */
public class Level1 implements LevelInformation {
    /**
     * return the number of balls on the level.
     *
     * @return the number of balls on the level.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * Note that initialBallVelocities().size() == numberOfBalls().
     *
     * @return List of the initial velocity of each ball.
     */
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(0, 5));
        return velocityList;
    }

    /**
     * the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * return the init paddle location.
     *
     * @return the init paddle location.
     */
    public Point paddleLocation() {
        return new Point(350, 560);
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "To the Moon";
    }

    /**
     * a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        return new Moon();
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the blocks of the level.
     */
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(380, 150), 50, 30)));
        blocks.get(0).setColor(Color.YELLOW);
        return blocks;
    }

    /**
     * the number of blocks needs to be removed.
     *
     * @return the number of blocks needs to be removed.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
