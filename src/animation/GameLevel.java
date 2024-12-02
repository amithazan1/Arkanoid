//318900545 Amit Hazan.
package animation;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import ball.Ball;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collidableObjects.Block;
import collidableObjects.Collidable;
import collidableObjects.GameEnvironment;
import collidableObjects.Paddle;
import levels.LevelInformation;
import listenerPattern.BlockRemover;
import listenerPattern.Counter;
import listenerPattern.ScoreTrackingListener;
import listenerPattern.BallRemover;
import java.awt.Color;
import java.util.Random;

/**
 * Game class will hold the sprites, the collidable and the level information and will be in charge of the animation.
 */
public class GameLevel implements Animation {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private final Counter numOfBlocks;
    private final Counter numOfBalls;
    private final Counter score;
    private final AnimationRunner runner;
    private boolean running;
    private final KeyboardSensor keyboard;
    private final LevelInformation levelInformation;

    /**
     * constructor.
     * @param runner - the animator runner.
     * @param score            - score of the game.
     * @param levelInformation - level information.
     * @param k - keyboard sensor.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner runner, Counter score, KeyboardSensor k) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.numOfBlocks = new Counter();
        this.numOfBalls = new Counter();
        this.score = score;
        this.runner = runner;
        this.keyboard = k;
        this.levelInformation = levelInformation;
    }

    /**
     * getter.
     *
     * @return the num of blocks remain in the level.
     */
    public Counter getNumOfBlocks() {
        return numOfBlocks;
    }

    /**
     * getter.
     *
     * @return the num of balls remain in the level.
     */
    public Counter getNumOfBalls() {
        return numOfBalls;
    }
    //Animation interface.

    /**
     * in charge of the logic of the game.
     *
     * @param d - the surface.
     */
    public void doOneFrame(DrawSurface d) {
        boolean paussed = false;
        if (this.keyboard.isPressed("p")) {
            paussed = true;
            this.runner.run(new KeyPressStoppableAnimation(keyboard, "space", new  PauseScreen(this.keyboard)));
        }
        if (paussed) {
            this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (numOfBlocks.getValue() == 0 || numOfBalls.getValue() == 0) {
            this.running = false;
        }
        if (numOfBlocks.getValue() == 0) {
            score.increase(100);
        }

    }

    /**
     * In charge of stopping condition.
     *
     * @return true - when should stop, false- otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * setter.
     * @param stop -.
     */
    public void setStop(boolean stop) {
        return;
    }
    //End of implement of the Animation interface.

    /**
     * add the given collidable to the environment.
     *
     * @param c - collidable object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * remove the given collidable from the environment.
     *
     * @param c - collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * add s to the list of sprites Objects.
     *
     * @param s - sprites object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * add s to the list of sprites Objects.
     *
     * @param s - sprites object.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }


    private void createBorders() {
        Block topBorder = new Block(new Rectangle(new Point(0, 0), 800, 40));
        topBorder.setColor(new Color(230, 7, 174));
        Block rightBorder = new Block(new Rectangle(new Point(790, 10), 10, 580));
        rightBorder.setColor(new Color(230, 7, 174));
        Block leftBorder = new Block(new Rectangle(new Point(0, 10), 10, 580));
        leftBorder.setColor(new Color(230, 7, 174));
        topBorder.addToGame(this);
        rightBorder.addToGame(this);
        leftBorder.addToGame(this);
    }

    /**
     * Initialize a new game: create the Blocks and Ball and Paddle.
     * and add them to the game
     */
    public void initialize() {
        Color color;
        //the background.
        this.addSprite(levelInformation.getBackground());
        //create the borders.
        this.createBorders();
        Block deathRegionBlock = new Block(new Rectangle(new Point(0, 590), 800, 10));
        deathRegionBlock.setColor(new Color(245, 2, 63));
        BlockRemover blockRemover = new BlockRemover(this, numOfBlocks);
        BallRemover ballRemover = new BallRemover(this, numOfBalls);
        deathRegionBlock.addToGame(this);
        //==== death-region block ====
        deathRegionBlock.addHitListener(ballRemover);
        //Create the score board.
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        this.addSprite(scoreIndicator);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        //Create the blocks.
        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            this.numOfBlocks.increase(1);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }
        //Create the paddle.
        Block pBlock = new Block(new Rectangle(levelInformation.paddleLocation(), levelInformation.paddleWidth(), 10));
        pBlock.setColor(Color.CYAN);
        Paddle paddle = new Paddle(keyboard, pBlock, levelInformation.paddleSpeed());
        paddle.addToGame(this);
        //Create the balls.
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 500, 10);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            numOfBalls.increase(1);
            ball.addToGame(this);
            ball.setGame(environment);
        }
    }

    private int[] randomLocations() {
        Random rand = new Random();
        int[] arr = new int[120];
        for (int i = 0; i < 60; i++) {
            arr[i] = rand.nextInt(770) + 30;
            arr[i + 1] = rand.nextInt(540) + 30;
        }
        return arr;
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }
}
