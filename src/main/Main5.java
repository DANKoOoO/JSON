package main;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Main5 {

	public static void main(String[] args) {
		
		try(FileWriter file = new FileWriter("movie_manula.json")) {
			JsonObject obj = new JsonObject();
			obj.addProperty("imdbId", "tt0016763");
			obj.addProperty("title", "From Dusk Till Dawn");
			obj.addProperty("releaseYear", 1996);
			obj.addProperty("rating", 7.2);
			
			JsonArray actors = new JsonArray();
			actors.add("George Clooney");
			actors.add("Quentin Tarantino");
			
			obj.add("actors", actors);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(obj, file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
