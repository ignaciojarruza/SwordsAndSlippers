package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Player.Stats;

public class StatsTest {
    private Stats testStats;

    @Before
    public void setup() {
        testStats = new Stats(0, 0, 0, 0, 0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Stats:\n-Strength: 0\n-Health: 0\n-Speed: 0\n -Wisdom: 0\n-Defense: 0\n", testStats.toString());
    }
}
