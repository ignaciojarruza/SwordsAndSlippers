package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    public void welcome() throws RemoteException;
}