package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class SnSServer extends UnicastRemoteObject implements Server {

    public SnSServer() throws RemoteException {
        super();
    }

    @Override
    public void welcome() throws RemoteException {
        System.out.println("First message from server in welcome message.");
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
