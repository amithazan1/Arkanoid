//318900545 Amit Hazan.

import animation.AnimationRunner;
import biuoop.GUI;
import levels.GameFlow;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.LevelInformation;

import java.util.ArrayList;


/**
 * run the game.
 */
public class Ass6Game {
    /**
     * Create a game object, initializes and runs it.
     *
     * @param args - nothing.
     */
    public static void main(String[] args) {
        ArrayList<LevelInformation> levels = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "1":
                    levels.add(new Level1());
                    break;
                case "2":
                    levels.add(new Level2());
                    break;
                case "3":
                    levels.add(new Level3());
                    break;
                case "4":
                    levels.add(new Level4());
                    break;
                default:
                    break;
            }
        }
        if (levels.isEmpty()) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        GameFlow game = new GameFlow(new AnimationRunner(new GUI("Arkanoid game", 800, 600)));
        game.runLevels(levels);

    }
}
