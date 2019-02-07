package gr.eap.mymovies.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.util.MoviesHelper;
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

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.json.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author akarafotis
 */
public class TMBDService {

    private int test;
    public static final String API_KEY = "1411ebbb56b1c62961d6bf46cd8c6860";
    public static final String BASE_URI = "https://api.themoviedb.org/3/";
    public static final String GENRES_URI = BASE_URI + "genre/movie/list?api_key=" + API_KEY;
    //public static final String MOVIES_PER_GENRE_URI = BASE_URI + "discover/movie?&with_genres=&release_date.gte=2000&api_key=" + API_KEY + "&page=";
    //public static final String MOVIES_PER_GENRE_URI = BASE_URI + "discover/movie?page={0}&with_genres={1}&release_date.gte=2000&api_key=" + API_KEY;

    private final CloseableHttpClient httpClient;

    public TMBDService() {
        httpClient = HttpClients.createDefault();
    }

    MoviesHelper mh = new MoviesHelper();

    public List<Genre> getGenres() {

        ArrayList<Genre> genres = new ArrayList<Genre>();

        HttpGet request = new HttpGet(GENRES_URI);
        CloseableHttpResponse response = null;
        JsonObject jsonObject = new JsonObject();

        try {
            response = httpClient.execute(request);
            System.out.println("Genres genres. response: " + response);

            InputStream content = response.getEntity().getContent();
            JsonParser parser = new JsonParser();

            Reader reader = new InputStreamReader(content, "UTF-8");

            JsonElement jsonElement = parser.parse(reader);
            jsonObject = jsonElement.getAsJsonObject();

            JsonObject jsonObjectListItem;

            int cnt = jsonObject.getAsJsonArray("genres").size();
            for (int i = 0; i < cnt; i++) {
                Genre genre = new Genre();
                jsonObjectListItem = jsonObject.getAsJsonArray("genres").get(i).getAsJsonObject();

                genre.setId(jsonObjectListItem.get("id").getAsInt());
                genre.setName(jsonObjectListItem.get("name").getAsString());

                genres.add(genre);
            }

            List<Genre> filteredGenres = genres.stream().filter(p -> p.getId() == 28 || p.getId() == 10749 || p.getId() == 878).collect(Collectors.toList());
            //getMoviesPerGenre(filteredGenres);

        } catch (Exception e) {
            System.out.println("An error occured while fetching genres: " + e);
        }

        return genres;

    }
    /*
    public void getMoviesPerGenre() {

        //Genre g = genre.get(0);
        //List<Movie> li = new List<Movie>();
        //Map<Genre, List<Movie moviesPerGenre = new HashMap<Genre, List<Movie>>();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesPU");
        EntityManager em = emf.createEntityManager();
        List<Genre> gList = em.createNamedQuery("Genre.findAll", Genre.class).getResultList();

        String url;

        for (Genre ge : gList) {
            url = BASE_URI + "discover/movie?&with_genres=" + ge.getId() + "&release_date.gte=2000&api_key=" + API_KEY + "&page=";

            HttpGet request;
            JsonObject jsonObject;
            CloseableHttpResponse response;
            InputStream content;
            JsonParser parser;
            Reader reader;
            JsonElement jsonElement;
            JsonObject jsonObjectListItem;

            for (int j = 1; j < 14; j++) {
                request = new HttpGet(url + String.valueOf(j));
                jsonObject = new JsonObject();
                try {
                    response = httpClient.execute(request);
                    content = response.getEntity().getContent();
                    parser = new JsonParser();
                    reader = new InputStreamReader(content, "UTF-8");
                    jsonElement = parser.parse(reader);
                    jsonObject = jsonElement.getAsJsonObject();
                    int cnt = jsonObject.getAsJsonArray("results").size();
                    for (int i = 0; i < cnt; i++) {
                        Movie movie = new Movie();
                        jsonObjectListItem = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject();
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
                    response = null;
                } catch (Exception e) {
                }
            }
        }
        em.getTransaction().begin();
        for (Movie movie : movies) {
            em.persist(movie);
        }

        em.getTransaction().commit();

    }
     */
 /*
        for (int p = 5; p < 7; p++) {

            HttpGet request = new HttpGet(MOVIES_PER_GENRE_URI + String.valueOf(p));
            CloseableHttpResponse response = null;
            JsonObject jsonObject = new JsonObject();

            try {
                response = httpClient.execute(request);
                System.out.println("GET 20 movies. response: " + response);

                InputStream content = response.getEntity().getContent();
                JsonParser parser = new JsonParser();

                Reader reader = new InputStreamReader(content, "UTF-8");

                JsonElement jsonElement = parser.parse(reader);
                jsonObject = jsonElement.getAsJsonObject();

                JsonObject jsonObjectListItem;

                int cnt = jsonObject.getAsJsonArray("results").size();
                for (int i = 0; i < cnt; i++) {
                    Movie movie = new Movie();
                    jsonObjectListItem = jsonObject.getAsJsonArray("results").get(i).getAsJsonObject();
//                ArrayList<Integer> genreIds = new ArrayList<Integer>();
//                int cnt2 = jsonObjectListItem.getAsJsonArray("genre_ids").size();
//                for (int j = 0; j < cnt2; j++) {}
                    movie.setGenreId(g);
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
                moviesPerGenre.put(g, movies);
            } catch (Exception e) {
                System.out.println("An error occured while fetching genres: " + e);
            }
        }
     */
    // return moviesPerGenre;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
