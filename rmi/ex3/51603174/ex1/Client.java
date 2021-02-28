import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	public Client() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			String name = args[2];
			int age = Integer.parseInt(args[3]);
			
			Registry registry = LocateRegistry.getRegistry(host, port);
			
			Hello stub = (Hello) registry.lookup("Hello");
			stub.printMsg(name, age);
			
			System.out.println("Remote method invoked!");
		}
		catch (RemoteException | NotBoundException ex) {
			ex.printStackTrace();
		}
	}
}
