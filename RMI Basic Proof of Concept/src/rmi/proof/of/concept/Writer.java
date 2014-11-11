package rmi.proof.of.concept;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An interface defining all the methods that can be called.
 * @author Etienne
 */
public interface Writer extends Remote{
    
    public String write() throws RemoteException;
    
}
