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

public class SnSServer extends UnicastRemoteObject implements Server {
    private Player playerOne;
    private Player playerTwo;
    private int playersInLobby;

    public SnSServer() throws RemoteException {
        super();
        this.playersInLobby = 0;
    }

    @Override
    public void welcome() throws RemoteException {
        System.out.println("First message from server in welcome message.");
    }

    @Override
    public String createPlayer() throws RemoteException {
        CharacterCreator characterCreator = new CharacterCreator();
        Player createdPlayer = characterCreator.getPlayer();
        return String.format("Character rerolled successfully.\n%s", createdPlayer.toString());
    }

    @Override
    public String enterArena(Player player) throws RemoteException {
        String result;
        if (playersInLobby == 0) {
            this.playerOne = player;
            this.playersInLobby++;
        } else if (playersInLobby == 1) {
            this.playerTwo = player;
            this.playersInLobby++;
        }
        else {
            while (this.playersInLobby != 2) {
                System.out.println("Waiting for second player...");
                TimeUnit.SECONDS.sleep(3);
            }
            Battle arena = new Arena(this.playerOne, this.playerTwo);
            result += arena.provideSummary();
            //Need to edit arena class to return string of total battle
        }
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
