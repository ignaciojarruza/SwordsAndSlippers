package Utilities;

import java.util.Random;

/**
 * The Die class can roll a value from 1 to 6.
 */
public class Die {
    private int value;
    private Random random;

    /**
     * Creates a new random for each die.
     */
    public Die() {
        random = new Random();
    }

    /**
     * Rolls a value from 1 to 6.
     * @return rolled value
     */
    public int roll() {
        value = random.nextInt(6) + 1;
        return value;
    }

    /**
     * Returns current value of die.
     * @return value
     */
    public int getValue() {
        return value;
    }
}
