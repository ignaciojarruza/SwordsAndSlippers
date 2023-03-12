package Player;
/**
 * Player Stats interface A player can have the attributes of strenght, health, speed, wisdom and defense.
 * 
 * @author Ignacio Arruza
 * @version 1.01
 */
public interface PlayerStats {

    /**
     * Sets the strength attribute to the desired value.
     * @param strength value
     */
    public void setStrength(int strength);

    /**
     * Sets the health attribute to the desired value.
     * @param health value
     */
    public void setHealth(int health);

    /**
     * Sets the speed attribute to the desired value.
     * @param speed value
     */
    public void setSpeed(int speed);

    /**
     * Sets the wisdom attribute to the desired value.
     * @param wisdom value
     */
    public void setWisdom(int wisdom);

    /**
     * Sets the defense attribute to the desired value.
     * @param defense value
     */
    public void setDefense(int defense);

    /**
     * Gets the strength attribute.
     * @return value of strength
     */
    public int getStrength();

    /**
     * Gets the health attribute.
     * @return value of health
     */
    public int getHealth();

    /**
     * Gets the speed attribute.
     * @return value of speed
     */
    public int getSpeed();

    /**
     * Gets the wisdom attribute.
     * @return value of wisdom
     */
    public int getWisdom();

    /**
     * Gets the defense attribute.
     * @return value of defense
     */
    public int getDefense();

    /**
     * Gets the base sum of attributes.
     * @return value of base stats
     */
    public int getBase();

    /**
     * Updates the strength value by the set amount. Value is added to attribute (can be positive or negative).
     * @param value to update strength by
     */
    public void updateStrength(int value);

    /**
     * Updates the health value by the set amount. Value is added to attribute (can be positive or negative).
     * @param value to update health by
     */
    public void updateHealth(int value);

    /**
     * Updates the speed value by the set amount. Value is added to attribute (can be positive or negative).
     * @param value to update speed by
     */
    public void updateSpeed(int value);

    /**
     * Updates the wisdom value by the set amount. Value is added to attribute (can be positive or negative).
     * @param value to update wisdom by
     */
    public void updateWisdom(int value);

    /**
     * Updates the defense value by the set amount. Value is added to attribute (can be positive or negative).
     * @param value to update defense by
     */
    public void updateDefense(int value);

    /**
     * Returns a copy of the stats object.
     * @return copy of stats object
     */
    public PlayerStats getStats();

    /**
     * Updates all attributes with values from passed stats object.
     * @param stats a stats object with attribute values
     */
    public void updateStats(PlayerStats stats);
}