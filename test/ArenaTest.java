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
 * 
 * @author Ignacio Arruza
 * @version 1.01
 */
public class ArenaTest {
    private Player player1;
    private Player player2;
    private Battle testArena;

    @Before
    public void setup() {
        player1 = new Mage("Player 1", new Stats(10, 10, 5, 5, 5));
        player2 = new Berserker("Player 2", new Stats(100, 100, 100, 100, 100));
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
        assertEquals("Player 2\nOf the Berserker Class\nStats:\n-Strength: 105\n-Health: 100\n-Speed: 100\n-Wisdom: 100\n-Defense: 100\n\nVS.\n\nPlayer 1\nOf the Mage Class\nStats:\n-Strength: 10\n-Health: 10\n-Speed: 5\n-Wisdom: 10\n-Defense: 5\n\n", testArena.provideSummary());
    }
}
