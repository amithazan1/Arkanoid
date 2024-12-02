package levels;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Aliens;
import animation.Sprite;
import ball.Velocity;
import collidableObjects.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 4 logic.
 */
public class Level4 implements LevelInformation {
    /**
     * return the number of balls on the level.
     *
     * @return the number of balls on the level.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * return list of the initial velocity of each ball.
     *
     * @return List of the initial velocity of each ball.
     */
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(60, 7));
        velocityList.add(Velocity.fromAngleAndSpeed(0, 7));
        velocityList.add(Velocity.fromAngleAndSpeed(300, 7));
        return velocityList;
    }

    /**
     * return the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * return the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 100;
    }
    /**
     * return the init paddle location.
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
        return "Alien Boss";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new Aliens();
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the blocks of the level.
     */
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Color color = Block.randomColor();
            for (int j = 0; j < 15; j++) {
                Block b = new Block(new Rectangle(new Point(10 + (52 * j), 90 + (20 * (i + 1))),
                        52, 20));
                b.setColor(color);
                blocks.add(b);
            }
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
