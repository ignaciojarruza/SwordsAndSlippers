package Arena;

import Player.Player;

/**
 * Arena class. In the arena, two players can battle until one reaches zero health.
 * Battles are automated so it is a passive game that takes attributes as the main core
 * engine.
 */
public class Arena implements Battle {
    private Player player1;
    private Player player2;

    /**
     * Arena Constructor: two players are required to create arena object.
     * @param player1 Player One
     * @param player2 Player Two
     */
    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String provideSummary() {
        return String.format("%s, %s", this.player1.toString(), this.player2.toString());
    }

    @Override
    public void battle() {
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println(player1.getName() + " has " + player1.getStats().getHealth() + " health left.");
            System.out.println(player2.getName() + " has " + player2.getStats().getHealth() + " health left.");
            player1.attack(player2);
            if (player2.isAlive()) {
                player2.attack(player1);
            }
        }

        if (player1.isAlive()) {
            System.out.println(player1.getName() + " wins!");
        } else if (player2.isAlive()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("Both players died!");
        }
    }
    
}
