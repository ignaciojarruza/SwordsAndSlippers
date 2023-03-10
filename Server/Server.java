package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Player.Player;

public interface Server extends Remote {
    public void welcome() throws RemoteException;
    public String createPlayer() throws RemoteException;
    public String enterArena(Player player) throws RemoteException;
}
