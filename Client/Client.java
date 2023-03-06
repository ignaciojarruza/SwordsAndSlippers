package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Server.Server;

public interface Client {
    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];
            
            Registry registry = LocateRegistry.getRegistry(null);
            Server stub = (Server)registry.lookup(String.format("rmi://%s:%s/server", server, port));
            stub.welcome();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
