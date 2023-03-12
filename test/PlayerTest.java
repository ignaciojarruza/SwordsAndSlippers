package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import Player.Berserker;
import Player.Player;
import Player.Stats;
import Player.PlayerStats;
import Player.Rogue;

/**
 * JUnit testing for Player functionality.
 */
public class PlayerTest {
    private Player testPlayer;
    private Player testDummyBag;

    @Before
    public void setup() {
        testPlayer = new Berserker("Mr. Apple", new Stats(5, 5, 5, 5, 5));
        testDummyBag = new Rogue("Dumb Player", new Stats(1, 10, 3, 5, 2));
    }

    @Test
    public void testConstructor() {
        assertEquals("Mr. Apple\nOf the Berserker Class\nStats:\n-Strength: 10\n-Health: 5\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n", testPlayer.toString());
    }

    @Test
    public void testGetName() {
        assertEquals("Mr. Apple", testPlayer.getName());
    }

    @Test
    public void testGetStats() {
        PlayerStats stats = testPlayer.getStats();
        assertEquals(10, stats.getStrength());
        assertEquals(5, stats.getHealth());
        assertEquals(5, stats.getSpeed());
        assertEquals(5, stats.getWisdom());
        assertEquals(5, stats.getDefense());
        assertEquals(30, stats.getBase());
    }

    @Test
    public void testUpdateStats() {
        testPlayer.updateStats(new Stats(10, 10, 10, 10 ,10));
        assertEquals("Mr. Apple\nOf the Berserker Class\nStats:\n-Strength: 10\n-Health: 10\n-Speed: 10\n-Wisdom: 10\n-Defense: 10\n", testPlayer.toString());
    }

    @Test
    public void testIsAlive() {
        assertTrue(testPlayer.isAlive());
        testPlayer.updateStats(new Stats(10, 0, 10, 10, 10));
        assertFalse(testPlayer.isAlive());
    }

    @Test
    public void testAttack() {
        testPlayer.attack(testDummyBag);
        PlayerStats dummyStats = testDummyBag.getStats();
        assertEquals(0, dummyStats.getHealth());
    }
}
