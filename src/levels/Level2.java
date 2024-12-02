package levels;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.SpaceShip;
import animation.Sprite;
import ball.Velocity;
import collidableObjects.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Level 2 logic.
 */
public class Level2 implements LevelInformation {

    /**
     * return the number of balls on the level.
     *
     * @return the number of balls on the level.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * return List of the initial velocity of each ball.
     *
     * @return List of the initial velocity of each ball.
     */
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls() / 2; i++) {
            velocityList.add(Velocity.fromAngleAndSpeed(0 + 28 * i, 6));
        }
        for (int i = 0; i < this.numberOfBalls() / 2; i++) {
            velocityList.add(Velocity.fromAngleAndSpeed(0 - 28 * i, 6));
        }
        return velocityList;
    }

    /**
     * return the paddle speed.
     *
     * @return - the paddle speed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * return the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 600;
    }

    /**
     * return the init paddle location.
     * @return the init paddle location.
     */
    public Point paddleLocation() {
        return new Point(100, 560);
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "Space Ship";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new SpaceShip();
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the blocks of the level.
     */
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            blocks.add(new Block(new Rectangle(new Point(10 + 52 * i, 300), 52, 30)));
        }
        return blocks;
    }

    /**
     * the number of blocks needs to be removed.
     *
     * @return the number of blocks needs to be removed.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
