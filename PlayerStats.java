/**
 * Player Stats interface.
 * @author Ignacio Arruza
 */
public interface PlayerStats {
    public void setStrength(int strength);
    public void setHealth(int health);
    public void setSpeed(int speed);
    public void setWisdom(int wisdom);
    public void setDefense(int defense);

    public int getStrength();
    public int getHealth();
    public int getSpeed();
    public int getWisdom();
    public int getDefense();

    public void updateStrength(int value);
    public void updateHealth(int value);
    public void updateSpeed(int value);
    public void updateWisdom(int value);
    public void updateDefense(int value);
}