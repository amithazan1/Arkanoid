//318900545 Amit Hazan.
package collidableObjects;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import animation.Sprite;
import ball.Ball;
import ball.Velocity;
import biuoop.DrawSurface;
import animation.GameLevel;
import listenerPattern.HitListener;
import listenerPattern.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * obstacles on the screen in shape of rectangle.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final List<HitListener> hitListeners = new ArrayList<>();
    private final Rectangle rectangle;
    private java.awt.Color color;

    /**
     * constructor.
     *
     * @param rec - rectangle object.
     */
    public Block(Rectangle rec) {
        this.rectangle = rec;
        this.color = randomColor();

    }

    /**
     * setter.
     *
     * @param color - color to change the block to.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * This method will be in charge of adding the block to the game,
     * calling the appropriate game methods.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * This method will be in charge of removing the block from the game,
     * calling the appropriate game methods.
     *
     * @param game - the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);

    }

    /**
     * choose Random color.
     *
     * @return random color.
     */
    public static Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }


    //Sprite.

    /**
     * draw the block on the given DrawSurface.
     *
     * @param surface - the panel to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int x = (int) this.rectangle.getUpperLeft().getX();
        int y = (int) this.rectangle.getUpperLeft().getY();
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
    }

    /**
     * for no does nothing.
     */
    @Override
    public void timePassed() {
        return;
    }


    //Collidable.

    /**
     * getter.
     *
     * @return the Collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          - the ball that's doing the hitting.
     * @param collisionPoint  - collision point with an object.
     * @param currentVelocity - current velocity of the ball.
     * @return - new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = this.rectangle.getUpperLeft().getX();
        double y = this.rectangle.getUpperLeft().getY();
        if (collisionPoint.getX() == x || collisionPoint.getX() == x + this.rectangle.getWidth()) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }
        if (collisionPoint.getY() == y || collisionPoint.getY() == y + this.rectangle.getHeight()) {
            currentVelocity.setDy(-currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }


    //HitNotifier.

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl - listener to add.
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);

    }

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - listener to remove.
     */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * will be called whenever a hit() occurs, and will notify all of the registered HitListener objects by calling
     * their hitEvent method.
     *
     * @param hitter - the ball that did the hit.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
