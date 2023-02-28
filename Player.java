public class Player {
    private String name;
    private Stats stats;

    public Player(String name, Stats stats) {
        this.name = name;
        this.stats = stats;
    }

    public void attack(Player opponent) {
        int damage = this.stats.getStrength() / ((opponent.stats.getDefense() + 100) / 100);
        
    }

    public String toString() {
        return String.format("%s\n%s", this.name, this.stats.toString());
    }
}
