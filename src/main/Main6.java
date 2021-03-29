package main;

import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Main6 {

    public static void main(String[] args) {

        try(FileReader reader = new FileReader("movie_manula.json")) {

            Gson gson = new Gson();

            JsonObject obj = gson.fromJson(reader, JsonObject.class);

            System.out.println( obj.get("imdbId").getAsString());
            System.out.println( obj.get("title").getAsString());
            System.out.println( obj.get("releaseYear").getAsInt());

            double rating = obj.get("rating").getAsDouble() - 1;
            System.out.println(rating);

            JsonArray actors = obj.getAsJsonArray("actors");
            System.out.println(actors.get(1).getAsString());
            System.out.println("\n");
            
            
            Set<Entry<String , JsonElement>> es = obj.entrySet();
            
            for(Entry<String, JsonElement> element: es)
            	System.out.println(element);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}