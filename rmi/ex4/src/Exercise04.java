import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Exercise04 extends Remote {
	
	public boolean findByFirstName(String firstname) throws RemoteException;
	public int countByLastName(String lastname) throws RemoteException;
	public boolean findById(String id) throws RemoteException;
	public float getMeanAge() throws RemoteException;
	public int getMinBD() throws RemoteException;
	public int getMaxBD() throws RemoteException;
	public int countByGender(String gender) throws RemoteException;
	public List<Person> getInfo(String address) throws RemoteException;
	public int countByState(String stateName) throws RemoteException;
}
