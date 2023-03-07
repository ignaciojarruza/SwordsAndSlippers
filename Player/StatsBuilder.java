package Player;

public class StatsBuilder {
    private int strength;
    private int health;
    private int speed;
    private int wisdom;
    private int defense;

    public StatsBuilder() {}

    public StatsBuilder strength(int strength) {
        this.strength = strength;
        return this;
    }

    public StatsBuilder health(int health) {
        this.health = health;
        return this;
    }

    public StatsBuilder speed(int speed) {
        this.speed = speed;
        return this;
    }

    public StatsBuilder wisdom(int wisdom) {
        this.wisdom = wisdom;
        return this;
    }

    public StatsBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    public Stats build() {
        Stats stats = new Stats(this.strength, this.health, this.speed, this.wisdom, this.defense);
        return stats;
    }
}
