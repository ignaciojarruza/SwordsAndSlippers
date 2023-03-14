package Player;

import java.io.Serializable;

/**
 * Stats class, supports maintaining attributes and the functionality that it requires.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class Stats implements PlayerStats, Serializable {

    private int strength;
    private int health;
    private int speed;
    private int wisdom;
    private int defense;

    /**
     * Stats empty constructor: sets all attributes to zero.
     */
    public Stats() {
        this.strength = 0;
        this.health = 0;
        this.speed = 0;
        this.wisdom = 0;
        this.defense = 0;
    }

    /**
     * Stats constructor: sets all attributes to passed values.
     * @param strength value for strength
     * @param health value for health
     * @param speed value for speed
     * @param wisdom value for wisdom
     * @param defense value for defense
     */
    public Stats(int strength, int health, int speed, int wisdom, int defense) {
        if (strength < 0 || health < 0 || speed < 0 || wisdom < 0 || defense < 0) {
            throw new IllegalArgumentException("Initial attributes cannot be set to a value below 0.");
        } else {
            this.strength = strength;
            this.health = health;
            this.speed = speed;
            this.wisdom = wisdom;
            this.defense = defense;
        }
    }

    @Override
    public void setStrength(int strength) throws IllegalArgumentException {
        if (strength < 0) {
            throw new IllegalArgumentException("Strength cannot be set to a value below 0.");
        } else {
            this.strength = strength;
        }
    }

    @Override
    public void setHealth(int health) throws IllegalArgumentException {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be set to a value below 0.");
        } else {
            this.health = health;
        }
    }

    @Override
    public void setSpeed(int speed) throws IllegalArgumentException {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be set to a value below 0.");
        } else {
            this.speed = speed;
        }
    }

    @Override
    public void setWisdom(int wisdom) throws IllegalArgumentException {
        if (wisdom < 0) {
            throw new IllegalArgumentException("Wisdom cannot be set to a value below 0.");
        } else {
            this.wisdom = wisdom;
        }
    }

    @Override
    public void setDefense(int defense) throws IllegalArgumentException {
        if (defense < 0) {
            throw new IllegalArgumentException("Defense cannot be set to a value below 0.");
        } else {
            this.defense = defense;
        }
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getWisdom() {
        return this.wisdom;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public int getBase() {
        return this.strength + this.health + this.speed + this.wisdom + this.defense;
    }

    @Override
    public void updateStrength(int value) {
        this.strength += value;
    }

    @Override
    public void updateHealth(int value) {
        this.health += value;
        if (this.health < 0) {this.health = 0;}
    }

    @Override
    public void updateSpeed(int value) {
        this.speed += value;
    }

    @Override
    public void updateWisdom(int value) {
        this.wisdom += value;
    }

    @Override
    public void updateDefense(int value) {
        this.defense += value;
    }
    
    @Override
    public String toString() {
        return String.format("Stats:\n-Strength: %d\n-Health: %d\n-Speed: %d\n-Wisdom: %d\n-Defense: %d\n", 
        this.strength, this.health, this.speed, this.wisdom, this.defense);
    }

    @Override
    public PlayerStats getStats() {
        return new Stats(this.getStrength(), this.getHealth(), this.getSpeed(), this.getWisdom(), this.getDefense());
    }

    @Override
    public void updateStats(PlayerStats stats) {
        this.strength = stats.getStrength();
        this.health = stats.getHealth();
        this.speed = stats.getSpeed();
        this.wisdom = stats.getWisdom();
        this.defense = stats.getDefense();
    }
}
