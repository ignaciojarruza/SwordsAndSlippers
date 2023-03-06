package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SnSServer implements Server {

    public SnSServer() {}

    @Override
    public void welcome() throws RemoteException {
        System.out.println("First message from server in welcome message.");
    }

    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];

            SnSServer gameServer = new SnSServer();
            Server stub = (Server)UnicastRemoteObject.exportObject(gameServer, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(String.format("rmi://%s:%s/server", server, port), stub);
        } catch (Exception e) {
            System.out.println("Server error:" + e.toString());
        }
    }
    
}
