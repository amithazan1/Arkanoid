//318900545 Amit Hazan.
package animation;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about all the Sprites that appear in the game.
 */
public class SpriteCollection {
    private final java.util.List<Sprite> spritesObjects;

    /**
     * constructor.
     * create a new array list.
     */
    public SpriteCollection() {
        this.spritesObjects = new ArrayList<Sprite>();
    }

    /**
     * add s to the list of sprites Objects.
     *
     * @param s - Sprite object to add.
     */
    public void addSprite(Sprite s) {
        this.spritesObjects.add(s);
    }

    /**
     * remove s from the list of sprites Objects.
     *
     * @param s - sprites object.
     */
    public void removeSprite(Sprite s) {
        this.spritesObjects.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.spritesObjects);
        for (Sprite spritesObject : spriteList) {
            spritesObject.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d - the panel to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite spritesObject : spritesObjects) {
            spritesObject.drawOn(d);
        }
    }
}
