package rmi.proof.of.concept;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client class for RMI. 
 * See also: Server.java.
 * @author Etienne
 */
public class Client {
    
    // RMI defaults.    
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PROTOCOL = "rmi";
    private static final String DEFAULT_HOSTNAME = "local";
    private static final int DEFAULT_PORT = 1099;    
    
    public static void main(String[] args){
        
        // Set Security Manager.
        // For RMI to download classes, a security manager must be in force.

        /*  This will cause errors if you don't have the right policies. disabled.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }        
        */
        
        // The following code can throw a RemoteException.
        try {
            
            // Connect to the server's registry.
            Registry registry = LocateRegistry.getRegistry(DEFAULT_HOST, DEFAULT_PORT);
            
            // Get the object from the server's registry.
            Writer writer = (Writer) registry.lookup("write");
            
            // Print output of the writer to see if everything works.
            System.out.println("Client: " + writer.write());
            
        // Catches exception by printing error.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}