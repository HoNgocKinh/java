

import java.rmi.RemoteException;

public class CusOperationImpl implements CusOperation {

	@Override
	public long add(int a, int b) throws RemoteException {

		return a + b;
	}

	@Override
	public long sub(int a, int b) throws RemoteException {

		return a - b;
	}
}
