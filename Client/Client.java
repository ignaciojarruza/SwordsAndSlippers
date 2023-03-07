package Client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import Server.Server;

public class Client {

    public void characterCreation() {
        System.out.println("");
    }
    public static void main(String[] args) {
        try {
            String server = args[0];
            String port = args[1];
            
            LocateRegistry.getRegistry(server, Integer.parseInt(port));
            Server stub = (Server)Naming.lookup(String.format("rmi://%s:%s/server", server, port));
            //stub.welcome();

            String input = "";
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //Character Creation or Login?
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.toString());
        }
    }
}
