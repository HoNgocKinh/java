

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CusOperation extends Remote {
	
	public long add(int a, int b) throws RemoteException;
	public long sub(int a, int b) throws RemoteException;
}
