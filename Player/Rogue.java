package Player;

/**
 * Rogue class scales damage with speed stat. Also has an innate +5 to speed.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class Rogue extends Player {

    /**
     * Rogue constructor. Adds rogue passive +5 to speed.
     * @param name name of character
     * @param stats stats object
     */
    public Rogue(String name, PlayerStats stats) {
        super(name, (new StatsBuilder().strength(stats.getStrength()).health(stats.getHealth()).speed(stats.getSpeed() + 5).wisdom(stats.getWisdom()).defense(stats.getDefense()).build()));
    }

    @Override
    public void attack(Player opponent, String battleLog) {
        PlayerStats opponentStats = opponent.getStats();
        int damage = -(this.stats.getStrength() + this.stats.getSpeed() / ((opponentStats.getDefense() + 100) / 100));
        opponentStats.updateHealth(damage);
        opponent.updateStats(opponentStats);
        battleLog += (String.format("%s hit %s for %d damage.", this.name, opponent.getName(), damage));
    }

    @Override
    public String toString() {
        return String.format("%s\nOf the Rogue Class\n%s", this.name, this.stats.toString());
    }
}
