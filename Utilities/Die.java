package Utilities;

import java.util.Random;

public class Die {
    private int value;
    private Random random;

    public Die() {
        random = new Random();
    }

    public int roll() {
        value = random.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }
}
