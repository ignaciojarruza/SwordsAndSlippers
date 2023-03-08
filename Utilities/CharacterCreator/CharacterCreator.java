package Utilities.CharacterCreator;

import Player.Player;
import Player.PlayerStats;
import Player.StatsBuilder;
import Utilities.Die;
import Utilities.NameGenerator.NameGenerator;

public class CharacterCreator {
    private Player createdPlayer;
    public CharacterCreator() {
        System.out.println("Welcome to the character creator!\nRolling dice for initial stats...\n");
        this.createdPlayer = new Player(this.rerollName(), this.rerollStats());
    }

    public PlayerStats rerollStats() {
        Die die = new Die();
        StatsBuilder statsBuilder = new StatsBuilder();
        PlayerStats stats = statsBuilder.strength(die.roll()).health(die.roll()*7).speed(die.roll()).wisdom(die.roll()).defense(die.roll()).build();
        System.out.println(String.format("Randomized Stats: %s", stats.toString()));
        return stats;
    }

    public Player getPlayer() {
        return this.createdPlayer;
    }

    public String rerollName() {
        System.out.println("Assigning random name...");
        String characterName = NameGenerator.generateName();
        System.out.println(String.format("Your character name is: %s", characterName));
        return characterName;
    }
}
