package Player;

import java.io.Serializable;

/**
 * Player class. A Player should have stats, a name
 * and the ability to battle with another player.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class Player implements Serializable {
    private String name;
    private PlayerStats stats;

    /**
     * Player constructor: intializes a Player with name and stats provided.
     * @param name name of th eplayer
     * @param stats the stat atributes of the player
     */
    public Player(String name, PlayerStats stats) {
        this.name = name;
        this.stats = stats;
    }
    
    /**
     * Returns the name of the player.
     * @return name of player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the stats object of the player.
     * @return stats 
     */
    public PlayerStats getStats() {
        return this.stats.getStats();
    }

    /**
     * Updates player attributes with passed stats.
     * @param stats new stats
     */
    public void updateStats(PlayerStats stats) {
        this.stats.updateStats(stats);
    }

    /**
     * Returns boolean for if the player is alive. True if player has health above 0, false otherwise.
     * @return true if alive, false if dead
     */
    public boolean isAlive() {
        return this.stats.getHealth() > 0;
    }

    /**
     * Attacks other opponent. Damage is calculated with player attack and opponent defense.
     * @param opponent
     */
    public void attack(Player opponent) {
        PlayerStats opponentStats = opponent.getStats();
        int damage = -(this.stats.getStrength() / ((opponentStats.getDefense() + 100) / 100));
        opponentStats.updateHealth(damage);
        opponent.updateStats(opponentStats);
        System.out.println(String.format("%s hit %s for %d damage.", this.name, opponent.getName(), damage));
    }

    /**
     * Returns a description containing player name and player attributes.
     */
    public String toString() {
        return String.format("%s\n%s", this.name, this.stats.toString());
    }
}
