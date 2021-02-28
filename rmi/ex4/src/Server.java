import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	
	public static void main(String[] args) {
		
		// using args : 0 => port;
		try {
			int port = Integer.parseInt(args[0]);
			
			Exercise04 exercise04Impl = new Exercise04Impl();
			Exercise04 skeleton = (Exercise04)UnicastRemoteObject.exportObject(exercise04Impl, 0);
			
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("Exercise04", skeleton);
			
			System.out.println("Server Oke!");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
