//318900545 Amit Hazan.
package listenerPattern;

/**
 * a simple class that is used for counting things.
 */
public class Counter {
    private int number;

    /**
     * constructor.
     */
    public Counter() {
        this.number = 0;
    }

    /**
     * add number to current count.
     *
     * @param number - number of blocks to add.
     */
    public void increase(int number) {
        this.number += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number - number of blocks to remove.
     */
    public void decrease(int number) {
        this.number -= number;
    }

    /**
     * get current count.
     *
     * @return current number of blocks.
     */
    public int getValue() {
        return this.number;
    }
}

