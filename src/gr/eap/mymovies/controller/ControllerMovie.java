package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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

        ArrayList<Integer> keys = new ArrayList<>();

        em.persist(movies.get(0));
        keys.add(0, movies.get(0).getId());

        for (int i = 1; i < movies.size(); i++) {
            if (!keys.contains(movies.get(i).getId())) {
                keys.add(i, movies.get(i).getId());
                em.persist(movies.get(i));
            } else {
                keys.add(i, -800 + i);
            }

        }
//        for (Movie movie : movies) {
//            em.persist(movie);
//        }
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
