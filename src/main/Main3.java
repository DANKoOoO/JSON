package main;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main3 {
	
	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setImdbId("1342131");
		m1.setTitle("AAAA");
		m1.setReleaseYear(1995);
		
		Movie m2 = new Movie();
		m2.setImdbId("12321314214");
		m2.setTitle("BBBBBB");
		m2.setReleaseYear(2004);
		
		Movie m3 = new Movie();
		m3.setImdbId("1242141214");
		m3.setTitle("CCCCC");
		m3.setReleaseYear(2013);
		
		//Movie[] movies = {m1, m2, m3};
		
		List<Movie> movies = new LinkedList<Movie>();
		movies.add(m1);
		movies.add(m3);
		movies.add(m2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter file = new FileWriter("many_movies.json")){
			
			gson.toJson(movies, file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
