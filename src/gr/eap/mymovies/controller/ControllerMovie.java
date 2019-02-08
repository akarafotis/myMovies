package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void retrieveAndPersistMovies() throws IOException, ParseException {

        em.getTransaction().begin();

        ArrayList<Movie> movies = tmdbService.getMoviesPerGenre();
        for (Movie movie : movies) {
            em.persist(movie);
        }
        em.getTransaction().commit();
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
