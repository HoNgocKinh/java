import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface WeatherPredicipitation extends Remote {

	public String cityPrecipitationMax() throws RemoteException;
	
	public String cityPrecipitationMin() throws RemoteException;
	
	public float meanPrecipitationState(String stationState) throws RemoteException;
	
	public Map<String, Double> statisticWindSpeedEachMonth() throws RemoteException;
	
	public Map<String, Integer> statisticTempurateMinEachState() throws RemoteException;
}
