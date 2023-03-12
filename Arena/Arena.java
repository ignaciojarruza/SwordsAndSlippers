package Arena;

import Player.Player;

/**
 * Arena class. In the arena, two players can battle until one reaches zero health.
 * Battles are automated so it is a passive game that takes attributes as the main core
 * engine.
 * 
 * @author Ignacio Arruza
 * @version 1.0
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
        this.establishFirstTurn(player1, player2);
    }

    private void establishFirstTurn(Player p1, Player p2) {
        if (p1.getStats().getSpeed() > p2.getStats().getSpeed()) {
            this.player1 = p1;
            this.player2 = p2;
        } else {
            this.player1 = p2;
            this.player2 = p1;
        }
    }

    @Override
    public String provideSummary() {
        return String.format("%s, %s\n", this.player1.toString(), this.player2.toString());
    }

    @Override
    public String battle() {
        String battleLog = "";
        while (player1.isAlive() && player2.isAlive()) {
            battleLog += (player1.getName() + " has " + player1.getStats().getHealth() + " health left.\n");
            battleLog += (player2.getName() + " has " + player2.getStats().getHealth() + " health left.\n");
            player1.attack(player2);
            if (player2.isAlive()) {
                player2.attack(player1);
            }
        }

        if (player1.isAlive()) {
            battleLog += (player1.getName() + " wins!");
        } else if (player2.isAlive()) {
            battleLog += (player2.getName() + " wins!");
        } else {
            battleLog += ("Both players died!");
        }
        return battleLog;
    }
    
}
