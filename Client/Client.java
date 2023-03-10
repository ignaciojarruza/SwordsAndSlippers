package Client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import Player.Player;
import Server.Server;
import Utilities.ViewHelper;

public class Client {
    private Player rolledCharacter;
    
    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];
            
            LocateRegistry.getRegistry(server, Integer.parseInt(port));
            Server stub = (Server)Naming.lookup(String.format("rmi://%s:%s/server", server, port));
            //stub.welcome();

            String input = "";
            Scanner scanner = new Scanner(System.in); //need to close scanner somewhere
            
            ViewHelper.printHeader("Sword & Sandals");
            ViewHelper.printLogo();
            System.out.println("Character creation is randomized. Welcome!");
            System.out.println(stub.createPlayer());

            //Add loop logic here
            boolean quit = false;
            while (!quit) {
                ViewHelper.printHeader("Main Menu");
                ViewHelper.printMainMenu();
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        System.out.println("You chose to reroll your character.");
                        //System.out.println(stub.createPlayer());
                        this.rolledCharacter = stub.createPlayer();
                        break;
                    case "2":
                        System.out.println("You chose to enter the Arena. Battle will commence once second player enters arena.");
                        stub.enterArena(null);
                        break;
                    case "3":
                        System.out.println("You chose to quit the game.");
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid command, please try available options.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
