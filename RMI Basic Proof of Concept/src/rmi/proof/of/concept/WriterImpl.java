package rmi.proof.of.concept;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * The implementation object for the Writer interface.
 * @author Etienne
 */
public class WriterImpl extends UnicastRemoteObject implements Writer{
    
    public WriterImpl() throws RemoteException{}

    @Override
    public String write() throws RemoteException {
        return "Invoked WriterImpl.write().";
    }   
    
}