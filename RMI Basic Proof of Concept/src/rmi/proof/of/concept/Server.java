package rmi.proof.of.concept;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * The Server class of this whole RMI mess.
 * @author Etienne
 */
public class Server {
    
    // RMI defaults.    
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PROTOCOL = "rmi";
    private static final String DEFAULT_HOSTNAME = "local";
    private static final int DEFAULT_PORT = 1099;    
    
    /**
     * Include a main() method so we can launch the server and client seperately.
     * @param args 
     */
    public static void main(String[] args){
        
        // The following code can throw a RemoteException.
        try { 
            
            // Set Security Manager.
            // For RMI to download classes, a security manager must be in force.
            
            /*  This will cause errors if you don't have the right policies. disabled.
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }            
            */
                    
            // Create the registry. Default port: 1099.
            // By binding it like this you don't need to use your command line.
            Registry registry = LocateRegistry.createRegistry(DEFAULT_PORT);

            // Instantiate the implementation class.
            WriterImpl w = new WriterImpl();
            
            // bind it to the registry.
            registry.bind("write", w);
            
        // Catches exception by printing error.
        } catch (Exception e) { 
            System.out.println(e.getMessage());
        }        
    }    
}