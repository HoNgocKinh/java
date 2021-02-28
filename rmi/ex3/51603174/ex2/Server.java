

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			
			int port = Integer.parseInt(args[0]);
			CusOperationImpl impl = new CusOperationImpl();
			CusOperation skeleton = (CusOperation) UnicastRemoteObject.exportObject(impl, 0);
			
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("CusOperation", skeleton);
			
			System.out.println("Server Invoke!");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
