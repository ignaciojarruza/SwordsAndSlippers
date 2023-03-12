package Player;

/**
 * Berserker class scales damage with strength stat. Also has an innate +5 to strength.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class Berserker extends Player {

    /**
     * Berserker constructor. Adds berserker passive +5 to strength.
     * @param name name of character
     * @param stats stats object
     */
    public Berserker(String name, PlayerStats stats) {
        super(name, (new StatsBuilder().strength(stats.getStrength() + 5).health(stats.getHealth()).speed(stats.getSpeed()).wisdom(stats.getWisdom()).defense(stats.getDefense()).build()));
    }

    @Override
    public void attack(Player opponent) {
        PlayerStats opponentStats = opponent.getStats();
        int damage = -(this.stats.getStrength() / ((opponentStats.getDefense() + 100) / 100));
        opponentStats.updateHealth(damage);
        opponent.updateStats(opponentStats);
        System.out.println(String.format("%s hit %s for %d damage.", this.name, opponent.getName(), damage));
    }
    
}
