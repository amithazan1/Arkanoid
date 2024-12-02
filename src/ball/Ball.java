//318900545 Amit Hazan.

package ball;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Sprite;
import biuoop.DrawSurface;
import collidableObjects.Collidable;
import collidableObjects.CollisionInfo;
import collidableObjects.GameEnvironment;
import animation.GameLevel;

import java.awt.Color;

/**
 * Represents a ball on the screen.
 */
public class Ball implements Sprite {
    private int size;
    private Point location;
    private final java.awt.Color color;
    private Velocity velocity;
    private final Point border = new Point(800, 600);
    private GameEnvironment game;

    /**
     * constructor.
     *
     * @param center - the location of the ball on the screen.
     * @param r      - radius.
     * @param color  - the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.location = center;
        this.size = r;
        this.color = color;
    }

    /**
     * constructor.
     *
     * @param x - the x value of the location.
     * @param y - the y value of the location.
     * @param r - radius.
     */
    public Ball(int x, int y, int r) {
        this.location = new Point(x, y);
        this.size = r;
        this.color = Color.CYAN;
    }

    /**
     * return the x value of the location.
     *
     * @return - the x value of the location.
     */
    public int getX() {
        return (int) this.location.getX();
    }

    /**
     * return the y value of the location.
     *
     * @return the y value of the location.
     */
    public int getY() {
        return (int) this.location.getY();
    }

    /**
     * return the radius of the ball.
     *
     * @return - the radius of the ball.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * return the color of the ball.
     *
     * @return - the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * get the velocity of a ball object.
     *
     * @return the velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * get the maximum height the ball can reach.
     *
     * @return - maximum height the ball can reach.
     */
    public int getBorderHeight() {
        return (int) this.border.getY();
    }

    /**
     * the maximum width the ball can reach.
     *
     * @return - the maximum width the ball can reach.
     */
    public int getBorderWidth() {
        return (int) this.border.getX();
    }

    /**
     * setter.
     *
     * @param size - the ball radius.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * set the velocity of a ball.
     *
     * @param v - Velocity object.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the velocity of a ball.
     *
     * @param dx - steps on the x axe.
     * @param dy - steps on the y axe.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }


    /**
     * set the borders that the ball can reach to.
     *
     * @param width  - width of the surface.
     * @param height - height of the surface.
     */
    public void setBorder(double width, double height) {
        this.border.setX(width);
        this.border.setY(height);
    }

    /**
     * set the X value of th center of the ball.
     *
     * @param x
     */
    public void setLocationX(int x) {
        this.location.setX(x);
    }

    /**
     * set the Y value of th center of the ball.
     *
     * @param y
     */
    public void setLocationY(int y) {
        this.location.setY(y);
    }

    /**
     * set the game environment.
     *
     * @param game - GameEnvironment object.
     */
    public void setGame(GameEnvironment game) {
        this.game = game;
    }

    // Sprite.

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.size);
        surface.setColor(new Color(72, 7, 237));
        surface.drawCircle(this.getX(), this.getY(), this.size);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * This method will be in charge of adding the ball to the game,
     * calling the appropriate game methods.
     *
     * @param g - the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * This method will be in charge of adding the ball to the game,
     * calling the appropriate game methods.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Checks whether the ball is inside the screen and not coming out of it.
     *
     * @return - If not return false, else return true.
     */
    public boolean isBallInRange() {
        double borderX = this.getBorderWidth();
        double borderY = this.getBorderHeight();
        if (this.location.getX() > borderX || this.location.getX() < 0) {
            return false;
        }
        return !(this.location.getY() > borderY) && !(this.location.getY() < 0);
    }

    /**
     * Moves the point according to the velocity.
     */
    public void moveOneStep() {
        Ball temp = new Ball((int) this.location.getX(), (int) this.location.getY(), this.getSize());
        temp.setVelocity(this.getVelocity());
        temp.setBorder(this.getBorderWidth(), this.getBorderHeight());
        boolean hit = false;
        Point closet;
        Collidable obstacle;
        Rectangle recObstacle;
        do {
            temp.location.setX(temp.getVelocity().applyToPoint(temp.location).getX());
            temp.location.setY(temp.getVelocity().applyToPoint(temp.location).getY());
        } while (temp.isBallInRange());
        //the trajectory is "how the ball will move without any obstacles".
        Line trajectory = new Line(this.location, temp.location);
        CollisionInfo closetCollisionI = game.getClosestCollision(trajectory);
        //there is a hit.
        if (closetCollisionI != null) {
            closet = closetCollisionI.collisionPoint();
            obstacle = closetCollisionI.collisionObject();
            recObstacle = obstacle.getCollisionRectangle();

            if (this.location.distance(closet) <= this.size) {
                hit = true;
                if (recObstacle.getUpperLeft().getY() + recObstacle.getHeight() == closet.getY()) { //bottom hit.
                    this.location.setY(closet.getY() + this.size);
                    this.location.setX(closet.getX());

                }
                if (recObstacle.getUpperLeft().getY() == closet.getY()) { //upper hit.
                    this.location.setY(closet.getY() - this.size);
                    this.location.setX(closet.getX());

                }
                if (recObstacle.getUpperLeft().getX() == closet.getX()) { //left side hit.
                    this.location.setX(closet.getX() - this.size);
                    this.location.setY(closet.getY());
                }
                if (recObstacle.getUpperLeft().getX() + recObstacle.getWidth() == closet.getX()) { //right side hit.
                    this.location.setX(closet.getX() + this.size);
                    this.location.setY(closet.getY());

                }
            }

            if (!hit) {
                this.location = this.getVelocity().applyToPoint(this.location);
            } else {
                this.setVelocity(obstacle.hit(this, closet, this.getVelocity()));
            }
        }
    }
}
