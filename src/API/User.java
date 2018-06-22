package API;

public class User {
	private String name;
	private String apiKey;
	private String longitude;
	private String latitude;
	
	public User() {
		apiKey = "e75803275624dcdc5def0e387fd8d803";
		longitude = "7.335888";   //Mulhouse Headquater
		latitude = "47.750839";   //Mulhouse Headquater
	}
	public User(String apiKey, String longitude, String latitude) {
		this.apiKey = apiKey;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


}
