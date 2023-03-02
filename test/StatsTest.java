package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Player.Stats;

public class StatsTest {
    private Stats testStats;

    @Before
    public void setup() {
        testStats = new Stats(5, 5, 5, 5, 5);
    }

    @Test
    public void testEmptyConstructor() {
        Stats emptyConstructorStats = new Stats();
        assertEquals("Stats:\n-Strength: 0\n-Health: 0\n-Speed: 0\n -Wisdom: 0\n-Defense: 0\n", emptyConstructorStats.toString());
    }

    @Test
    public void testConstructor() {
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 5\n -Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructor() {
        Stats illegalConstructorStats = new Stats(-1, 2, 3, 4, 5);
    }

    @Test
    public void testSetStrength() {
        testStats.setStrength(3);
        assertEquals("Stats:\n-Strength: 3\n-Health: 5\n-Speed: 5\n -Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetStrength() {
        testStats.setStrength(-3);
    }

    @Test
    public void testSetHealt() {
        testStats.setHealth(3);
        assertEquals("Stats:\n-Strength: 5\n-Health: 3\n-Speed: 5\n -Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }
}
