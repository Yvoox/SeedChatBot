package Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static String[] weatherParser(String latitude, String longitude, String apiKey) throws IOException, JSONException {
		String[] reply = new String[4];
		String description = null;
		String tempMin = null;
		String tempMax = null;
		String areaName = null;
		JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&APPID="+apiKey);


		JSONArray weather = json.getJSONArray("weather");

		System.out.println(weather);
		areaName = json.getString("name");

		for(int i = 0; i < weather.length(); i++){
			JSONObject obj = weather.getJSONObject(i);
			description = obj.getString("description");
		}

		JSONObject main = json.getJSONObject("main");
		tempMin = main.get("temp_min").toString();
		tempMax = main.get("temp_max").toString();
		
		//Celsius convert
		double kelvin = 273.15;
		tempMin = Double.toString((Double.parseDouble(tempMin) - kelvin));
		tempMax = Double.toString((Double.parseDouble(tempMax) - kelvin));

		reply[0] = areaName;
		reply[1] = description;
		reply[2] = tempMin;
		reply[3] = tempMax;


		   return reply;
	}

}
