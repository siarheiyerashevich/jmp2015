package service;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import client.FIFAServiceClient;
import client.WeatherServiceClient;

@WebService
public class MyService {

	private static final FIFAServiceClient FIFA_SERVICE_CLIENT = FIFAServiceClient.getInstacne();
	private static final WeatherServiceClient WEATHER_SERVICE_CLIENT = WeatherServiceClient.getInstacne();

	@WebMethod
	public List<String> weatherOfWMCities() {
		List<String> weathers = new ArrayList<>();
		List<String> cities = FIFA_SERVICE_CLIENT.getCities();
		for (String city : cities) {
			weathers.add(WEATHER_SERVICE_CLIENT.getWeather(city, "country"));
		}
		return weathers;
	}

	@WebMethod
	public int cardsOfTeam() {
		int cardsOfTeam = 0;
		String teamName = FIFA_SERVICE_CLIENT.getRandomTeamName();
		cardsOfTeam += FIFA_SERVICE_CLIENT.getRedCards(teamName);
		cardsOfTeam += FIFA_SERVICE_CLIENT.getYellowCards(teamName);
		return cardsOfTeam;
	}
}
