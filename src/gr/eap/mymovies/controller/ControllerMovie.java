package gr.eap.mymovies.controller;

import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 *
 * @author akarafotis
 */
public class ControllerMovie extends AppController {

    private final DBService dbService;
    private final TMBDService tmdbService;
    private final MoviesHelper moviesHelper;

    public ControllerMovie() {
        super();

        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
        moviesHelper = new MoviesHelper();
    }

    public void retrieveAndPersistMovies() {

//        String a = "{0} and {1}";
//
//        MessageFormat.format(a, "r","t");
//
//        return;
//        System.out.println("Calling TMDB to retrieve data...");
        List<Genre> genres = tmdbService.getGenres();
        //System.out.println(genres);

        // Filter out unwanted genres
        genres = moviesHelper.filteroutGenres(genres);

        Map<Genre, List<Movie>> movies = tmdbService.getMoviesPerGenre(genres);

        System.out.println("Persisting data to local DB...");

        em.getTransaction().begin();
        for (List<Movie> valueList : movies.values()) {
            for (Movie movie : valueList) {
                em.persist(movie);
            }
        }
        em.getTransaction().commit();

        // Persist Genres
        dbService.persistGenres(genres);

        // Persist Movies
        dbService.persistMovies(movies);
    }

    /*Εύρεση ταινίας με το αντίστοιχο Id*/
    public Movie findMovieById(int movieId) {
        return em.find(Movie.class, movieId);
    }

    @Override
    public void clearTable() {
        clearTbl("Movie.deleteAll");
    }
}
