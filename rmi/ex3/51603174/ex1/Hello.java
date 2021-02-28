

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
	
	public void printMsg(String name, int age) throws RemoteException;
}
