
public class Weather {
	
	private float precipitation;
	private String dateFull;
	private int month;
	private int weekOf;
	private int year;
	private String stationCity;
	private String stationCode;
	private String stationLocation;
	private String stationState;
	private int temperatureAvg;
	private int temperatureMax;
	private int temperatureMin;
	private int windDirection;
	private float windSpeed;
	
	public Weather() { }
	public Weather(String... data) {
		int index = 0;
		this.precipitation = Float.parseFloat(data[index++]);
		this.dateFull = data[index++];
		this.month = Integer.parseInt(data[index++]);
		this.weekOf = Integer.parseInt(data[index++]);
		this.year = Integer.parseInt(data[index++]);
		this.stationCity = data[index++];
		this.stationCode = data[index++];
		this.stationLocation = data[index++];
		this.stationState = data[index++];
		this.temperatureAvg = Integer.parseInt(data[index++]);
		this.temperatureMax = Integer.parseInt(data[index++]);
		this.temperatureMin = Integer.parseInt(data[index++]);
		this.windDirection = Integer.parseInt(data[index++]);
		this.windSpeed = Float.parseFloat(data[index++]);
	}
	
	public float getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(float precipitation) {
		this.precipitation = precipitation;
	}
	public String getDateFull() {
		return dateFull;
	}
	public void setDateFull(String dateFull) {
		this.dateFull = dateFull;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getWeekOf() {
		return weekOf;
	}
	public void setWeekOf(int weekOf) {
		this.weekOf = weekOf;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStationCity() {
		return stationCity;
	}
	public void setStationCity(String stationCity) {
		this.stationCity = stationCity;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationLocation() {
		return stationLocation;
	}
	public void setStationLocation(String stationLocation) {
		this.stationLocation = stationLocation;
	}
	public String getStationState() {
		return stationState;
	}
	public void setStationState(String stationState) {
		this.stationState = stationState;
	}
	public int getTemperatureAvg() {
		return temperatureAvg;
	}
	public void setTemperatureAvg(int temperatureAvg) {
		this.temperatureAvg = temperatureAvg;
	}
	public int getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public int getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
}
