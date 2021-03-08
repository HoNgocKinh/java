import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private static List<Weather> weathers = new ArrayList<Weather>();
	
	public static void main(String[] args) {
		
		int port = Integer.parseInt(args[0]);
		
		WeatherPredicipitation weatherPredicipitation = new WeatherPredicipitationImpl(weathers);
		
		importFile();
		
		try {
			WeatherPredicipitation skeleton = (WeatherPredicipitation) UnicastRemoteObject.exportObject(weatherPredicipitation, 0);
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("WeatherPredicipitation", skeleton);
			
			System.out.println("Server running!");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void importFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File("weather.csv")))) {
			
			br.lines().map(line -> line.substring(1, line.length() - 2))
			.filter(l -> l.indexOf("Data.Precipitation") == -1)
			.forEach(line -> {
				String[] elements = line.split("(\"\\,\")");
				weathers.add(new Weather(elements));
			});
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
