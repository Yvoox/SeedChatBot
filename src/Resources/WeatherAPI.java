package Resources;

import java.io.IOException;

import org.json.JSONException;

import API.User;

public class WeatherAPI {

	private static String apiURL = "http://api.openweathermap.org/data/2.5/weather?";


	public static String[] getWeather() {

		User current = new User();
		//TODO get the real informations of the user !!!
		try {
			return JSONParser.weatherParser(current.getLatitude(), current.getLongitude(), current.getApiKey());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
