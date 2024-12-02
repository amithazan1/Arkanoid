//318900545 Amit Hazan.
package collidableObjects;

import BasicShapes.Line;
import BasicShapes.Point;

import java.util.ArrayList;

/**
 * During the game, there are going to be many objects a Ball can collide with.
 * The GameEnvironment class will be a collection of such things.
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    private final java.util.List<Collidable> collidablesObjects;

    /**
     * constructor.
     * create a new array list.
     */
    public GameEnvironment() {
        this.collidablesObjects = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c - collidable object.
     */
    public void addCollidable(Collidable c) {
        this.collidablesObjects.add(c);
    }

    /**
     * remove the given collidable from the environment.
     *
     * @param c - collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.collidablesObjects.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory - Line object.
     * @return - the collision point and collision object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // In case there are no obstacles.
        if (this.collidablesObjects.size() == 0) {
            return null;
        }
        boolean flag = true;
        int index = 0;
        double minDistance = 0;
        Point closestCollision = null;
        Point temp;
        for (int i = 0; i < collidablesObjects.size(); i++) {
            Collidable obstacle = this.collidablesObjects.get(i);
            temp = trajectory.closestIntersectionToStartOfLine(obstacle.getCollisionRectangle());
            // In case the trajectory does not collide with the current obstacle.
            if (temp == null) {
                continue;
            }
            if (flag) {
                minDistance = temp.distance(trajectory.start());
                index = i;
                closestCollision = temp;
                flag = false;
                continue;
            }

            if (temp.distance(trajectory.start()) < minDistance) {
                minDistance = temp.distance(trajectory.start());
                index = i;
                closestCollision = temp;
            }
        }
        // In case the trajectory does not collide with any of the obstacles.
        if (flag) {
            return null;
        }
        return new CollisionInfo(closestCollision, collidablesObjects.get(index));
    }
}



