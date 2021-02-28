

import java.rmi.RemoteException;

public class ImplHello implements Hello {

	@Override
	public void printMsg(String name, int age) throws RemoteException {
		
		System.out.printf("Hello %s - Age: %d", name, age);
	}
}
