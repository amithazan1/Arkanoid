//318900545 Amit Hazan.
package collidableObjects;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Sprite;
import ball.Ball;
import ball.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import animation.GameLevel;

/**
 * The Paddle is the player in the game. It is a rectangle that is controlled by the arrow keys,
 * and moves according to the player key presse
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private final Block paddle;
    private int speed;

    /**
     * constructor.
     *
     * @param keyboard - the keyboard of the game.
     * @param paddle   - the paddle of the game.
     * @param speed - the speed of the paddle.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Block paddle, int speed) {
        this.keyboard = keyboard;
        this.paddle = paddle;
        this.speed = speed;
    }

    /**
     * Move the paddle to the left according to the player's click.
     */
    public void moveLeft() {
        double x = paddle.getCollisionRectangle().getUpperLeft().getX();
        if (x - this.speed < 10) {
            return;
        }
        paddle.getCollisionRectangle().getUpperLeft().setX(x - this.speed);
    }

    /**
     * Move the paddle to the right according to the player's click.
     */
    public void moveRight() {
        double x = paddle.getCollisionRectangle().getUpperLeft().getX();
        if (x + this.speed + this.paddle.getCollisionRectangle().getWidth() > 790) {
            return;
        }
        paddle.getCollisionRectangle().getUpperLeft().setX(x + this.speed);
    }

    // Sprite

    /**
     * check if the "left" or "right" keys are pressed, and if so move it accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle on the panel.
     *
     * @param d - the panel.
     */
    public void drawOn(DrawSurface d) {
        paddle.drawOn(d);
    }

    // Collidable

    /**
     * return the shape of the block.
     *
     * @return - the shape of the block.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * And returns a new speed to the ball depending on the location of the hit.
     * Divide the ball into 5 parts.
     * If you hit 1 (the far left part) the angle of the ball will be 300.
     * If you hit 2 330 and so on each time add 30 degrees until you reach part 5 (include).
     *
     * @param hitter          - the ball that's doing the hitting.
     * @param collisionPoint  - collision point with an object.
     * @param currentVelocity - current velocity of the ball.
     * @return - the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] sections = new Line[5];
        double len = this.paddle.getCollisionRectangle().getWidth() / 5;
        Point upperLeft = this.paddle.getCollisionRectangle().getUpperLeft();
        double xStartPoint;
        double xEndPoint = upperLeft.getX() + len;
        double yValue = upperLeft.getY();
        double angle = 0;
        sections[0] = new Line(upperLeft, new Point(xEndPoint, yValue));
        xStartPoint = xEndPoint;
        xEndPoint = upperLeft.getX() + (2 * len);
        sections[1] = new Line(new Point(xStartPoint, yValue), new Point(xEndPoint, yValue));
        xStartPoint = xEndPoint;
        xEndPoint = upperLeft.getX() + (3 * len);
        sections[2] = new Line(new Point(xStartPoint, yValue), new Point(xEndPoint, yValue));
        xStartPoint = xEndPoint;
        xEndPoint = upperLeft.getX() + (4 * len);
        sections[3] = new Line(new Point(xStartPoint, yValue), new Point(xEndPoint, yValue));
        xStartPoint = xEndPoint;
        xEndPoint = upperLeft.getX() + (5 * len);
        sections[4] = new Line(new Point(xStartPoint, yValue), new Point(xEndPoint, yValue));
        for (int i = 0; i < 5; i++) {
            if (sections[i].isOnLine(collisionPoint.getX(), collisionPoint.getY())) {
                angle = 300 + (30 * i);
                break;
            }
        }
        return Velocity.fromAngleAndSpeed(angle, 5);
    }

    /**
     * Add this paddle to the game.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}