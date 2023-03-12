package Player;

/**
 * Mage class scales damage with wisdom stat. Also has an innate +5 to wisdom.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class Mage extends Player {

    /**
     * Mage constructor. Adds mage passive +5 to wisdom.
     * @param name name of character
     * @param stats stats object
     */
    public Mage(String name, PlayerStats stats) {
        super(name, (new StatsBuilder().strength(stats.getStrength()).health(stats.getHealth()).speed(stats.getSpeed()).wisdom(stats.getWisdom() + 5).defense(stats.getDefense()).build()));
    }

    @Override
    public void attack(Player opponent) {
        PlayerStats opponentStats = opponent.getStats();
        int damage = -(this.stats.getStrength() + this.stats.getWisdom() / ((opponentStats.getDefense() + 100) / 100));
        opponentStats.updateHealth(damage);
        opponent.updateStats(opponentStats);
        System.out.println(String.format("%s hit %s for %d damage.", this.name, opponent.getName(), damage));
    }

    @Override
    public String toString() {
        return String.format("%s\nOf the Mage Class\n%s", this.name, this.stats.toString());
    }
    
}
