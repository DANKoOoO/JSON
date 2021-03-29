package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main7 {
	
	private static final String BASE_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "2e4baadf5c5ae6ba436f53ae5558107f";
	private static final String SOURCE = "USD";
	private static final String CURRENCIES = "EUR";
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		try {
			URL url = new URL(BASE_URL + "/live?access_key=" + API_KEY + 
					"&source=" + SOURCE + "&currencies=" + CURRENCIES);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			
			BufferedReader reader =
					new BufferedReader(
							new InputStreamReader(con.getInputStream()));
			
			JsonObject rez = gson.fromJson(reader, JsonObject.class);
			
			System.out.println(rez);
			
			if(rez.get("success").getAsBoolean()) {
				
				double kurs = rez.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
				
				System.out.println("Kurs je "+kurs);
			}


		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
