package Utilities.CharacterCreator;

import java.util.Random;

import Player.Berserker;
import Player.Mage;
import Player.Player;
import Player.PlayerStats;
import Player.Rogue;
import Player.StatsBuilder;
import Utilities.Die;
import Utilities.NameGenerator.NameGenerator;

/**
 * The CharacterCreator class is responsible for creating new player characters with random names and stats.
 * The creator has the functionality of allowing the player to reroll indefinitely.
 * 
 * @version 1.0
 */
public class CharacterCreator {
    private Player createdPlayer;

    /**
     * Constructor: generates a randomized character.
     */
    public CharacterCreator() {
        System.out.println("Rolling dice for initial stats...\n");
        this.createdPlayer = CharacterCreator.randomClass(this.rerollName(), this.rerollStats());
    }

    /**
     * Creates a player with passed name and stats
     * with a random class assigned.
     * @param name of character
     * @param stats object
     * @return player object
     */
    private static Player randomClass(String name, PlayerStats stats)  {
        Random random = new Random();
        switch(random.nextInt(3) + 1) {
            case 1:
                return new Rogue(name, stats);
            case 2:
                return new Mage(name, stats);
            default:
                return new Berserker(name, stats);
        }
    }
    /**
     * Rerolls the stat attributes of the player. Uses the die class to randomize stat generation.
     * 
     * @return randomized stats object
     */
    public PlayerStats rerollStats() {
        Die die = new Die();
        StatsBuilder statsBuilder = new StatsBuilder();
        PlayerStats stats = statsBuilder.strength(die.roll()).health(die.roll()*7).speed(die.roll()).wisdom(die.roll()).defense(die.roll()).build();
        System.out.println(String.format("Randomized Stats: %s", stats.toString()));
        return stats;
    }

    /**
     * Returns the rerolled player.
     * @return Player object
     */
    public Player getPlayer() {
        return this.createdPlayer;
    }

    /**
     * Generates a random name with a preset of prefixes, suffixes. Uses the NameGenerator class.
     * 
     * @return randomized name
     */
    public String rerollName() {
        System.out.println("Assigning random name...");
        String characterName = NameGenerator.generateName();
        System.out.println(String.format("Character name: %s", characterName));
        return characterName;
    }
}
