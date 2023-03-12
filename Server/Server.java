package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Player.Player;

/**
 * The Server Interface provides remote access to server-side functionalities
 * including player creation and arena entry.
 * 
 * @author Ignacio Arruza
 */
public interface Server extends Remote {
    public void welcome() throws RemoteException;

    /**
     * Creates a new player with a randomized name and randomized stats.
     * 
     * @return Player object
     * @throws RemoteException RMI error in remote invocation
     */
    public Player createPlayer() throws RemoteException;

    /**
     * Player enters arena and waits until second player enters in order to engage
     * in combat. A winner is named afterwards. Battle engine is held in Arena class.
     * 
     * @param player player to enter arena
     * @return log of entire Arena battle with other player
     * @throws RemoteException RMI error in remote invocation
     */
    public String enterArena(Player player) throws RemoteException;
}
