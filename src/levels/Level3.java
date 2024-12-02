package levels;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Rocket;
import animation.Sprite;
import ball.Velocity;
import collidableObjects.Block;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 3 logic.
 */
public class Level3 implements LevelInformation {
    /**
     * return the number of balls on the level.
     *
     * @return the number of balls on the level.
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * return List of the initial velocity of each ball.
     *
     * @return List of the initial velocity of each ball.
     */
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(60, 5));
        velocityList.add(Velocity.fromAngleAndSpeed(300, 5));
        return velocityList;
    }

    /**
     * return the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 8;
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
        return "Flying Rocket";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new Rocket();
    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the blocks of the level.
     */
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Color color = Block.randomColor();
            for (int j = 1; j <= 12 - i; j++) {
                Block b = new Block(new Rectangle(new Point(790 - (50 * j), 100 + (30 * (i + 1))),
                        50, 30));
                b.setColor(color);
                blocks.add(b);
            }
        }
        return blocks;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return the number of blocks needs to be removed.
     */
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
