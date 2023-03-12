package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * The Client interface represents a client that can connect to a server and
 * interact with it by displaying a title screen and running its main game loop.
 * 
 * @author Ignacio Arruza
 */
public interface Client {

    /**
     * Connects to the server using the specified parameters.
     * @param server serverAddress the IP address or hostname of the server
     * @param port the port number to connect to on the server
     * @throws RemoteException RMI error in performing remote invocation
     * @throws MalformedURLException RMI error in registry URL
     * @throws NotBoundException RMI error binding server object
     */
    public void connectToServer(String server, String port) throws RemoteException, MalformedURLException, NotBoundException;
    
    /**
     * Displays the title screen of the game.
     */
    public void displayTitleScreen();

    /**
     * Runs the main game loop, which interacts with the server and updates
     * the game state based on the server's responses.
     * 
     * @throws RemoteException RMI error in performing remote invocation
     */
    public void run() throws RemoteException;
}
