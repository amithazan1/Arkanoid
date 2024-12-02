package levels;

import animation.AnimationRunner;
import animation.EndScreen;
import animation.GameLevel;
import animation.KeyPressStoppableAnimation;
import biuoop.KeyboardSensor;
import listenerPattern.Counter;

import java.util.List;

/**
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private final KeyboardSensor keyboardSensor;
    private final AnimationRunner runner;
    private final Counter score;

    /**
     * constructor.
     *
     * @param runner - animation runner.
     */
    public GameFlow(AnimationRunner runner) {
        this.runner = runner;
        this.keyboardSensor = this.runner.getGui().getKeyboardSensor();
        this.score = new Counter();
    }

    /**
     * Run all the levels in the game.
     *
     * @param levels - the levels of the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, runner, score, keyboardSensor);
            level.initialize();
            while (level.getNumOfBalls().getValue() != 0 && level.getNumOfBlocks().getValue() != 0) {
                level.run();
            }
            if (level.getNumOfBalls().getValue() == 0 || levels.indexOf(levelInfo) == levels.size() - 1) {
                this.runner.run(new KeyPressStoppableAnimation(keyboardSensor, "space",
                        new EndScreen(keyboardSensor, score, level.getNumOfBalls(), level.getNumOfBlocks())));
                this.runner.getGui().close();
            }
        }
    }
}


