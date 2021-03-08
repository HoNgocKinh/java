import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeatherPredicipitationImpl implements WeatherPredicipitation {

	private List<Weather> weathers = null;
	
	public WeatherPredicipitationImpl(List<Weather> weathers) {
		this.weathers = weathers;
	}
	
	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	@Override
	public String cityPrecipitationMax() throws RemoteException {
		Map<Object, List<Weather>> groupingByCity = weathers.stream().parallel()
							.collect(Collectors.groupingBy(w -> w.getStationCity()));
		
		return countPrecipitationBy(groupingByCity, true);
	}
	private String countPrecipitationBy(Map<Object, List<Weather>> groupingByCity, boolean orderByMax) {
		
		Map<String, Double> groupingByPrecipitation = new HashMap<String, Double>();
		
		groupingByCity.forEach((key, listWeather) -> {
			double precipitationOfCity = 0d;
			if (orderByMax) {
				precipitationOfCity = listWeather.stream().mapToDouble(w -> w.getPrecipitation()).max().getAsDouble();
			}
			else {
				precipitationOfCity = listWeather.stream().mapToDouble(w -> w.getPrecipitation()).min().getAsDouble();
			}
			groupingByPrecipitation.put(key.toString(), precipitationOfCity);
		});
		
		String keyPoint = groupingByPrecipitation.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		return keyPoint;
	}
	
	@Override
	public String cityPrecipitationMin() throws RemoteException {
		
		Map<Object, List<Weather>> groupingByCity = weathers.stream().parallel()
				.collect(Collectors.groupingBy(w -> w.getStationCity()));

		return countPrecipitationBy(groupingByCity, false);
	}

	@Override
	public float meanPrecipitationState(String stationState) throws RemoteException {
		
		if (stationState.isEmpty()) return -1;
		
		Map<Object, List<Weather>> groupingByState = weathers.stream().parallel()
				.collect(Collectors.groupingBy(w -> w.getStationState()));
		double meanPrecipitation = groupingByState.get(stationState).stream().parallel().mapToDouble(w -> w.getPrecipitation()).average().getAsDouble();
		return (float) meanPrecipitation;
	}

	@Override
	public Map<String, Double> statisticWindSpeedEachMonth() throws RemoteException {
		// Each month of 2016
		
		Map<Object, List<Weather>> groupingByMonth = weathers.stream().parallel()
				.collect(Collectors.groupingBy(w -> w.getMonth()));
		Map<String, Double> monthsAndAvgWindSpeed = new HashMap<String, Double>();
		
		groupingByMonth.forEach((key, listWeather) -> {
			double averageWindSpeed = listWeather.stream().mapToDouble(w -> w.getWindSpeed()).average().getAsDouble();
			monthsAndAvgWindSpeed.put(key.toString(), averageWindSpeed);
		});
		
		return monthsAndAvgWindSpeed;
	}

	@Override
	public Map<String, Integer> statisticTempurateMinEachState() throws RemoteException {
		
		Map<Object, List<Weather>> groupingByState = weathers.stream().parallel()
				.collect(Collectors.groupingBy(w -> w.getStationState()));
		
		Map<String, Integer> statesAndMinTemp = new HashMap<String, Integer>();
		groupingByState.forEach((key, listWeather) -> {
			int minTemp = listWeather.stream().parallel().mapToInt(w -> w.getTemperatureMin()).min().getAsInt();
			statesAndMinTemp.put(key.toString(), minTemp);
		});
		
		return statesAndMinTemp;
	}
}
