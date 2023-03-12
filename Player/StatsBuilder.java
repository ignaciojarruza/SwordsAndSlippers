package Player;

/**
 * The StatsBuilder class follows the builder pattern to construct a Stats object with
 * instance variables for strength, health, speed, wisdom and defense.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class StatsBuilder {
    private int strength;
    private int health;
    private int speed;
    private int wisdom;
    private int defense;

    /**
     * Creates a new StatsBuilder object.
     */
    public StatsBuilder() {}

    /**
     * Sets the strength attribute of the Stats object being built.
     * 
     * @param strength the value to set the strength stat
     * @return this StatsBuilder object to allow for method chaining
     */
    public StatsBuilder strength(int strength) {
        this.strength = strength;
        return this;
    }

    /**
     * Sets the health attribute of the Stats object being built.
     * 
     * @param health the value to set the health stat
     * @return this StatsBuilder object to allow for method chaining
     */
    public StatsBuilder health(int health) {
        this.health = health;
        return this;
    }

    /**
     * Sets the speed attribute of the Stats object being built.
     * 
     * @param speed the value to set the speed stat
     * @return this StatsBuilder object to allow for method chaining
     */
    public StatsBuilder speed(int speed) {
        this.speed = speed;
        return this;
    }

    /**
     * Sets the wisdom attribute of the Stats object being built.
     * 
     * @param wisdom the value to set the wisdom stat
     * @return this StatsBuilder object to allow for method chaining
     */
    public StatsBuilder wisdom(int wisdom) {
        this.wisdom = wisdom;
        return this;
    }

    /**
     * Sets the defense attribute of the Stats object being built.
     * 
     * @param defense the value to set the defense stat
     * @return this StatsBuilder object to allow for method chaining
     */
    public StatsBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    /**
     * Builds the stats object with the set attributes.
     * @return the built stats object
     */
    public Stats build() {
        Stats stats = new Stats(this.strength, this.health, this.speed, this.wisdom, this.defense);
        return stats;
    }
}
