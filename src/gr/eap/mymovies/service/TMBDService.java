/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.eap.mymovies.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author pkarafotis
 */
public class TMBDService {

    public static final String API_KEY = "1411ebbb56b1c62961d6bf46cd8c6860";

    public static final String GENRES_URI = "https://api.themoviedb.org/3/genre/movie/list?api_key=" + API_KEY;

    public static final String MOVIES_PER_GENRE_URI = "https://api.themoviedb.org/3/discover/movie?page={0}&with_genres={1}&release_date.gte=2000&api_key=" + API_KEY;

    private CloseableHttpClient httpClient;

    public TMBDService() {
        httpClient = HttpClients.createDefault();
    }

    public List<Genre> getGenres() {
        HttpGet request = new HttpGet(GENRES_URI);
        CloseableHttpResponse response = null;
            JsonObject jsonObject = new JsonObject();
            
        try {
            response = httpClient.execute(request);
            System.out.println(response);

            InputStream content = response.getEntity().getContent();
            JsonParser parser = new JsonParser();
            
            Reader reader = new InputStreamReader(content, "UTF-8");
            
            JsonElement jsonElement = parser.parse(reader);
            jsonObject = jsonElement.getAsJsonObject();

        } catch (Exception e) {
            System.out.println("An error occured while fetching genres: " + e);
        }

        return null;
    }

    public Map<Genre, List<Movie>> getMoviesPerGenre(List<Genre> genre) {
        return null;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
