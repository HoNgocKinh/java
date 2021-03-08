import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String[] args) {
		
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		String fncName = args[2];
		String fncParam = "";
			
		try {
			Registry registry = LocateRegistry.getRegistry(host, port);
			WeatherPredicipitation stub = (WeatherPredicipitation)registry.lookup("WeatherPredicipitation");
			
			switch (fncName) {
				case ("-city-precipitation"):
					fncParam = args[3];
					switch (fncParam) {
						case("-max"):
							System.out.println("cityPrecipitationMax: " + stub.cityPrecipitationMax());
						break;
						default: // min
							System.out.println("cityPrecipitationMin: " + stub.cityPrecipitationMin());
						break;
					}
				break;
				case ("-meanprecipitation"):
					fncParam = args[3];
					System.out.println("meanPrecipitationState: " + stub.meanPrecipitationState(fncParam));
					break;
				case ("-windmonth"):
					System.out.println("statisticWindSpeedEachMonth: " + stub.statisticWindSpeedEachMonth());
				break;
				case ("-temperature"):
					System.out.println("statisticTempurateMinEachState: " + stub.statisticTempurateMinEachState());
				break;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
