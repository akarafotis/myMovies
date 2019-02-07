package gr.eap.mymovies.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.json.*;
import java.util.*;
import javax.persistence.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.util.MoviesHelper;
import java.text.ParseException;
import java.util.*;

public class TestClass {

    private int test;
    public static final String API_KEY = "1411ebbb56b1c62961d6bf46cd8c6860";
    public static final String BASE_URI = "https://api.themoviedb.org/3/";
    public static final String GENRES_URI = BASE_URI + "genre/movie/list?api_key=" + API_KEY;

    public static void getMoviesPerGenreNew() throws IOException, ParseException {

        ArrayList<Movie> movies = new ArrayList<Movie>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesPU");
        EntityManager em = emf.createEntityManager();
        List<Genre> gList = em.createNamedQuery("Genre.findAll", Genre.class).getResultList();

        String url;
        ArrayList<Integer> keys = new ArrayList<Integer>();

        for (Genre ge : gList) {

            url = BASE_URI + "discover/movie?&with_genres=" + ge.getId() + "&release_date.gte=2000&api_key=" + API_KEY + "&page=";

            for (int i = 1; i < 14; i++) {
                URL url1 = new URL(url + String.valueOf(i));
                JsonReader reader1 = Json.createReader(new InputStreamReader(url1.openStream()));
                JsonObject cityDataObject = reader1.readObject();
                JsonArray cityHoursArray = cityDataObject.getJsonArray("results");
                reader1.close();

                for (int j = 0; j < 20; j++) {
                    Movie movie = new Movie();
                    JsonObject temp = cityHoursArray.getJsonObject(j);
                    movie.setGenreId(ge);
                    movie.setId(Integer.parseInt(temp.get("id").toString()));
                    //movie.setOverview(jsonObjectListItem.get("overview").getAsString());
                    movie.setRating(Double.parseDouble(temp.get("vote_average").toString()));
                    String releaseDate = temp.get("release_date").toString();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date convertedDate = sdf.parse(releaseDate);
                    movie.setReleaseDate(convertedDate);
                    movie.setTitle(temp.get("title").toString());

                    if (!keys.contains(movie.getId())) {
                        keys.add(movie.getId());
                        movies.add(movie);
                    }
                    /*
                    em.getTransaction().begin();
                    em.persist(movie);
                    em.getTransaction().commit();
                     */
                }

                /* for (int j = 0; j < 20; i++) {
                    Movie movie = new Movie();
                    movie.jsonObjectListItem = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject();
                    movie.setGenreId(ge);
                    movie.setId(jsonObjectListItem.get("id").getAsInt());
                    //movie.setOverview(jsonObjectListItem.get("overview").getAsString());
                    movie.setRating(jsonObjectListItem.get("vote_average").getAsDouble());
                    String releaseDate = jsonObjectListItem.get("release_date").getAsString();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date convertedDate = sdf.parse(releaseDate);
                    movie.setReleaseDate(convertedDate);
                    movie.setTitle(jsonObjectListItem.get("title").getAsString());
                    movies.add(movie);
                }
                 */
            }
        }

        for (Movie movie : movies) {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            System.out.println("Inserted movie : " + movie.getId().toString());
        }

    }
}
