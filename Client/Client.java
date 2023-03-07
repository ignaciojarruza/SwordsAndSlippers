package Client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Server.Server;

public interface Client {
    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];
            
            LocateRegistry.getRegistry(server, Integer.parseInt(port));
            Server stub = (Server)Naming.lookup(String.format("rmi://%s:%s/server", server, port));
            stub.welcome();
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
