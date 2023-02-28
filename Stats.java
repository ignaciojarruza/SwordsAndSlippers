public class Stats implements PlayerStats {

    private int strength;
    private int health;
    private int speed;
    private int wisdom;
    private int defense;

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    @Override
    public void setDefense(int defense) {
        this.defense = defense;
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
    public void updateStrength(int value) {
        this.strength += value;
    }

    @Override
    public void updateHealth(int value) {
        this.health += value;
    }

    @Override
    public void updateSpeed(int value) {
        this.speed += speed;
    }

    @Override
    public void updateWisdom(int value) {
        this.wisdom += wisdom;
    }

    @Override
    public void updateDefense(int value) {
        this.defense += defense;
    }
    
    @Override
    public String toString() {
        return String.format("Stats:\n-Strength: %d\n-Health: %d\n-Speed: %d\n -Wisdom: %d\n-Defense: %d\n", 
        this.strength, this.health, this.speed, this.wisdom, this.defense);
    }
}
