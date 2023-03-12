package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

import Arena.Arena;
import Arena.Battle;
import Player.Player;
import Utilities.CharacterCreator.CharacterCreator;

/**
 * SnSServer class is responsible for implementing the Server interface and
 * providing remote access to its methods via Java RMI. It extends UnicastRemoteObject
 * to make it a remote object that can be accessed by clients from other JVMs.
 * 
 * The class creates a registry on the specified port number, binds the remote object
 * with a name in the registry, and starts listening for incomign client requests.
 * 
 * @author Ignacio Arruza
 * @version 1.0
 */
public class SnSServer extends UnicastRemoteObject implements Server {
    private Player playerOne;
    private Player playerTwo;
    private int playersInLobby;
    private boolean full;

    /**
     * Constructs the new SnSServer object.
     * @throws RemoteException
     */
    public SnSServer() throws RemoteException {
        super();
        this.playersInLobby = 0;
    }

    @Override
    public void welcome() throws RemoteException {
        System.out.println("First message from server in welcome message.");
    }

    @Override
    public Player createPlayer() throws RemoteException {
        CharacterCreator characterCreator = new CharacterCreator();
        Player createdPlayer = characterCreator.getPlayer();
        return createdPlayer;
    }

    @Override
    public String enterArena(Player player) throws RemoteException {
        String result = "";
        if (playersInLobby == 0) {
            this.playerOne = player;
            this.playersInLobby++;
            while (!this.full) {
                System.out.println(this.full);
                System.out.println("Waiting for second player...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ie) {
                    System.out.println(ie.toString());
                }
            }
            this.full = false;
        } else if (playersInLobby == 1) {
            this.playerTwo = player;
            this.playersInLobby++;
            this.full = true;
        }
        Battle arena = new Arena(this.playerOne, this.playerTwo);
        result += arena.provideSummary();
        result += arena.battle();
        this.playersInLobby = 0;
        return result;
    }

    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];

            SnSServer gameServer = new SnSServer();
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind(String.format("rmi://%s:%s/server", server, port), gameServer);
        } catch (Exception e) {
            System.out.println("Server error:" + e.toString());
        }
    }
}
