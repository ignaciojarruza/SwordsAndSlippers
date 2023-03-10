package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import Player.Player;
import Server.Server;
import Utilities.ViewHelper;

public class Client {
    private Server stub;
    private Player rolledCharacter;

    public void connectToServer(String server, String port) throws RemoteException, MalformedURLException, NotBoundException {
        LocateRegistry.getRegistry(server, Integer.parseInt(port));
        this.stub = (Server)Naming.lookup(String.format("rmi://%s:%s/server", server, port));
    }

    public void displayTitleScreen() {
        ViewHelper.printHeader("Sword & Sandals");
        ViewHelper.printLogo();
    }

    public void run() throws RemoteException {
        System.out.println("Character creation is randomized. Welcome!");
        this.rolledCharacter = stub.createPlayer();
        System.out.println(this.rolledCharacter.toString());

        String input = "";
        Scanner scanner = new Scanner(System.in); //need to close scanner somewhere
        boolean quit = false;
        while (!quit) {
            ViewHelper.printHeader("Main Menu");
            ViewHelper.printMainMenu();
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("You chose to reroll your character.");
                    this.rolledCharacter = stub.createPlayer();
                    System.out.println(this.rolledCharacter.toString());
                    break;
                case "2":
                    System.out.println("You chose to enter the Arena. Battle will commence once second player enters arena.");
                    System.out.println(stub.enterArena(this.rolledCharacter));
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
    }
    
    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];
            
            Client client = new Client();
            client.connectToServer(server, port);
            client.run();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
