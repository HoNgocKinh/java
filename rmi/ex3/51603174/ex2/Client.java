import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public Client() {
		
	}
	
	public static void main(String[] args) {
		
		try {
			String host = args[0];
		
			int port = Integer.parseInt(args[1]);
			int a = Integer.parseInt(args[2]);
			int b = Integer.parseInt(args[3]);
			
			Registry registry = LocateRegistry.getRegistry(host, port);
			CusOperation cusOperation = (CusOperation) registry.lookup("CusOperation");
		
			System.out.println(cusOperation.add(a, b));
			System.out.println(cusOperation.sub(a, b));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
