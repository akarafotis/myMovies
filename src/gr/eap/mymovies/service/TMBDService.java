package gr.eap.mymovies.service;

import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.*;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class TMBDService {

    public static final String API_KEY = "1411ebbb56b1c62961d6bf46cd8c6860";
    public static final String BASE_URI = "https://api.themoviedb.org/3/";
    public static final String GENRES_URI = BASE_URI + "genre/movie/list?api_key=" + API_KEY;
    public static final String MOVIES_URI = BASE_URI + "discover/movie?&with_genres=28|10749|878&release_date.gte=2000&api_key=" + API_KEY + "&page=";

    public TMBDService() {
    }

    // methodos pou epistrefei ta lamvanomena Genres apo to api
    public List<Genre> getGenres() throws MalformedURLException, IOException {

        ArrayList<Genre> genres = new ArrayList<>();
        URL url = new URL(GENRES_URI);

        // apotikefsi twn dedomenwn se JsonArray
        JsonReader reader = Json.createReader(new InputStreamReader(url.openStream()));
        JsonObject genreObject = reader.readObject();
        JsonArray gernesArray = genreObject.getJsonArray("genres");
        reader.close();
        // gia kathe JsonObject tou JsonArray dimiourgoume ena Genre
        // kai apotikeuoume se auto to id & name pou mas endiaferoun
        for (int i = 0; i < gernesArray.size(); i++) {
            Genre genre = new Genre();
            JsonObject temp = gernesArray.getJsonObject(i);
            genre.setId(Integer.parseInt(temp.get("id").toString()));
            genre.setName(temp.get("name").toString());
            // prosthetoume to Genre sto ArrayList<Genre> genres
            genres.add(genre);
        }
        // filtraroume mono ta 3 gernes pou mas endiaferoun kai ta epistrefoume
        List<Genre> filteredGenres = genres.stream().filter(p -> p.getId() == 28 || p.getId() == 10749 || p.getId() == 878).collect(Collectors.toList());
        return filteredGenres;
    }

    // methodos pou epistrefei tis lamvanomenes Tainies apo to api
    public ArrayList<Movie> getMoviesPerGenre() throws IOException, ParseException {

        ArrayList<Movie> movies = new ArrayList<>();
        // arxikopoihsi tou EntityManagerFactory & EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMoviesPU");
        EntityManager em = emf.createEntityManager();
        // tha kanoume 40 epanallipseis - oses kai o periorismos tou api
        for (int i = 1; i < 40; i++) {
            // se kathe epanalipsi pername os parametro to page number
            URL url = new URL(MOVIES_URI + String.valueOf(i));
            // apotikefsi twn dedomenwn se JsonArray
            JsonReader reader = Json.createReader(new InputStreamReader(url.openStream()));
            JsonObject movieObject = reader.readObject();
            JsonArray moviesArray = movieObject.getJsonArray("results");
            reader.close();
            // gia kathe JsonObject tou JsonArray dimiourgoume ena movie
            // kai apotikeuoume se auto ta properties pou mas endiaferoun
            for (int j = 0; j < moviesArray.size(); j++) {
                ArrayList<Integer> genreIdsPerMovie = new ArrayList<>();
                int movieGenre;
                Movie movie = new Movie();
                JsonObject temp = moviesArray.getJsonObject(j);
                JsonArray genreIds = temp.getJsonArray("genre_ids");
                // orizoume tin proteraiotita me tin opoia ta oristei to
                // genre gia kathe tainia
                for (int g = 0; g < genreIds.size(); g++) {
                    genreIdsPerMovie.add(genreIds.getInt(g));
                }
                if (genreIdsPerMovie.contains(28)) {
                    movieGenre = 28;
                } else if (genreIdsPerMovie.contains(10749)) {
                    movieGenre = 10749;
                } else {
                    movieGenre = 878;
                }
                // vriskoume to genreOfMovie me xrisi NamedQuery
                Genre genreOfMovie = em.createNamedQuery("Genre.findById", Genre.class).setParameter("id", movieGenre).getSingleResult();

                movie.setGenreId(genreOfMovie);
                movie.setId(Integer.parseInt(temp.get("id").toString()));
                movie.setOverview(temp.get("overview").toString());
                movie.setRating(Double.parseDouble(temp.get("vote_average").toString()));
                // metasximatizoume katallila tin hmeromhnia sto sosto format
                String releaseDate = temp.get("release_date").toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date convertedDate = sdf.parse(releaseDate);
                movie.setReleaseDate(convertedDate);
                movie.setTitle(temp.get("title").toString());
                // prosthetoume to movie sto ArrayList<Movie> movies
                movies.add(movie);
                System.out.println("Added Movie: " + movie.getId());
            }
        }
        return movies;
    }
}
