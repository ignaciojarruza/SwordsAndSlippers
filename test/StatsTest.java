package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import Player.PlayerStats;
import Player.Stats;

/**
 * JUnit testing for Stats functionality.
 */
public class StatsTest {
    private Stats testStats;

    @Before
    public void setup() {
        testStats = new Stats(5, 5, 5, 5, 5);
    }

    @Test
    public void testEmptyConstructor() {
        Stats emptyConstructorStats = new Stats();
        assertEquals("Stats:\n-Strength: 0\n-Health: 0\n-Speed: 0\n-Wisdom: 0\n-Defense: 0\n", emptyConstructorStats.toString());
    }

    @Test
    public void testConstructor() {
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalConstructor() {
        Stats illegalConstructorStrength = new Stats(-1, 2, 3, 4, 5);
        Stats illegalConstructorHealth = new Stats(1, -2, 3, 4, 5);
        Stats illegalConstructorSpeed = new Stats(1, 2, -3, 4, 5);
        Stats illegalConstructorWisdom = new Stats(1, 2, 3, -4, 5);
        Stats illegalConstructorDefense = new Stats(1, 2, 3, 4, -5);
    }

    @Test
    public void testSetStrength() {
        testStats.setStrength(3);
        assertEquals("Stats:\n-Strength: 3\n-Health: 5\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetStrength() {
        testStats.setStrength(-3);
    }

    @Test
    public void testSetHealt() {
        testStats.setHealth(3);
        assertEquals("Stats:\n-Strength: 5\n-Health: 3\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetHealth() {
        testStats.setHealth(-4);
    }

    @Test
    public void testSetSpeed() {
        testStats.setSpeed(14);
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 14\n-Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetSpeed() {
        testStats.setSpeed(-12);
    }

    @Test
    public void testSetWisdom() {
        testStats.setWisdom(4);
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 5\n-Wisdom: 4\n-Defense: 5\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetWisdom() {
        testStats.setWisdom(-23);
    }

    @Test
    public void testSetDefense() {
        testStats.setDefense(12);
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 5\n-Wisdom: 5\n-Defense: 12\n", testStats.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSetDefense() {
        testStats.setDefense(-12);
    }

    @Test
    public void testGetStrength() {
        assertEquals(5, testStats.getStrength());
        testStats.setStrength(12);
        assertEquals(12, testStats.getStrength());
    }

    @Test
    public void testGetHealth() {
        assertEquals(5, testStats.getHealth());
        testStats.setHealth(13);
        assertEquals(13, testStats.getHealth());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(5, testStats.getSpeed());
        testStats.setSpeed(7);
        assertEquals(7, testStats.getSpeed());
    }

    @Test
    public void testGetWisdom() {
        assertEquals(5, testStats.getWisdom());
        testStats.setWisdom(4);
        assertEquals(4, testStats.getWisdom());
    }

    @Test
    public void testGetDefense() {
        assertEquals(5, testStats.getDefense());
        testStats.setDefense(15);
        assertEquals(15, testStats.getDefense());
    }

    @Test
    public void testGetBase() {
        assertEquals(25, testStats.getBase());
    }

    @Test
    public void testUpdateStrength() {
        testStats.updateStrength(5);
        assertEquals(10, testStats.getStrength());
        testStats.updateStrength(-5);
        assertEquals(5, testStats.getStrength());
    }

    @Test
    public void testUpdateHealth() {
        testStats.updateHealth(5);
        assertEquals(10, testStats.getHealth());
        testStats.updateHealth(-5);
        assertEquals(5, testStats.getHealth());
    }

    @Test
    public void testUpdateSpeed() {
        testStats.updateSpeed(5);
        assertEquals(10, testStats.getSpeed());
        testStats.updateSpeed(-5);
        assertEquals(5, testStats.getSpeed());
    }

    @Test
    public void testUpdateWisdom() {
        testStats.updateWisdom(5);
        assertEquals(10, testStats.getWisdom());
        testStats.updateWisdom(-5);
        assertEquals(5, testStats.getWisdom());
    }

    @Test
    public void testUpdateDefense() {
        testStats.updateDefense(5);
        assertEquals(10, testStats.getDefense());
        testStats.updateDefense(-5);
        assertEquals(5, testStats.getDefense());
    }

    @Test
    public void testToString() {
        assertEquals("Stats:\n-Strength: 5\n-Health: 5\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n", testStats.toString());
    }

    @Test
    public void testGetStats() {
        PlayerStats stats = testStats.getStats();
        assertEquals(5, stats.getStrength());
        assertEquals(5, stats.getHealth());
        assertEquals(5, stats.getSpeed());
        assertEquals(5, stats.getWisdom());
        assertEquals(5, stats.getDefense());
        assertEquals(25, stats.getBase());
    }
}
