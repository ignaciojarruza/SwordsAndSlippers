package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import Arena.*;
import Player.*;

/**
 * JUnit test for Arena functionality.
 */
public class ArenaTest {
    private Player player1;
    private Player player2;
    private Battle testArena;

    @Before
    public void setup() {
        player1 = new Player("Player 1", new Stats(10, 10, 5, 5, 5));
        player2 = new Player("Player 2", new Stats(100, 100, 100, 100, 100));
        testArena = new Arena(player1, player2);
    }

    @Test
    public void testBattle() {
        testArena.battle();
        assertTrue(player2.isAlive());
        assertFalse(player1.isAlive());
    }

    @Test
    public void testSummary() {
        assertEquals("Player 1\nStats:\n-Strength: 10\n-Health: 10\n-Speed: 5\n-Wisdom: 5\n-Defense: 5\n, Player 2\nStats:\n-Strength: 100\n-Health: 100\n-Speed: 100\n-Wisdom: 100\n-Defense: 100\n", testArena.provideSummary());
    }
}
