package client;

import weather.client.GlobalWeather;
import weather.client.GlobalWeatherSoap;

public class WeatherServiceClient {
	private static final WeatherServiceClient INSTANCE = new WeatherServiceClient();
	private GlobalWeatherSoap port;

	private WeatherServiceClient() {
		GlobalWeather service = new GlobalWeather();
		port = service.getGlobalWeatherSoap();
	}

	public String getWeather(String cityName, String countryName) {
		return port.getWeather(cityName, countryName);
	}

	public static WeatherServiceClient getInstacne() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		System.out.println("Waeather in Minsk: ");
		System.out.println(WeatherServiceClient.getInstacne().getWeather("Minsk", "Belarus"));
	}
}
