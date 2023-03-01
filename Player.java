public class Player {
    private String name;
    private Stats stats;

    public Player(String name, Stats stats) {
        this.name = name;
        this.stats = stats;
    }
    
    public String getName() {
        return this.name;
    }

    public PlayerStats getStats() {
        return this.stats.getStats();
    }

    public void updateStats(PlayerStats stats) {
        this.stats.updateStats(stats);
    }

    public void attack(Player opponent) {
        PlayerStats opponentStats = opponent.getStats();
        int damage = -(this.stats.getStrength() / ((opponentStats.getDefense() + 100) / 100));
        opponentStats.setHealth(damage);
        opponent.updateStats(opponentStats);
        System.out.println(String.format("%s hit %s for %d damage.", this.name, opponent.getName(), damage));
    }

    public String toString() {
        return String.format("%s\n%s", this.name, this.stats.toString());
    }
}
