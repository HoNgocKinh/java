import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplHello {
	
	public Server() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			int port = Integer.parseInt(args[0]);
			
			ImplHello helloImpl = new ImplHello();
			
			Hello skeleton = (Hello) UnicastRemoteObject.exportObject(helloImpl, 0);
			
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("Hello", skeleton);
			
			System.out.println("Server Ready!");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
