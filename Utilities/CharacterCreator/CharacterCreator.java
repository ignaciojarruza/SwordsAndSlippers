package Utilities.CharacterCreator;

import java.util.Scanner;

import Player.Stats;
import Utilities.Die;
import Utilities.NameGenerator.NameGenerator;

public class CharacterCreator {
    
    public CharacterCreator(Scanner scanner) {
        boolean create = false;

        while (!create) {
            Die die = new Die();
            System.out.println("Welcome to the character creator!\nRolling dice for initial stats...\n");
            System.out.println(String.format("Strength: %d", die.roll()));
            System.out.println(String.format("Health: %d", die.roll()*7));
            System.out.println(String.format("Speed: %d", die.roll()));
            System.out.println(String.format("Wisdom: %d", die.roll()));
            System.out.println(String.format("Defense: %d", die.roll()));

            //want to implement the builder pattern on the stats object.

            //Want to add a random name generator here
            System.out.println("Assigning random name...");
            String characterName = NameGenerator.generateName();
            System.out.println(String.format("Your character name is: %s", characterName));
        }
    }
}
