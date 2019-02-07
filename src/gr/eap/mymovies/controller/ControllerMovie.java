package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.service.TestClass;
import gr.eap.mymovies.util.MoviesHelper;
import java.text.MessageFormat;
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

    public void retrieveAndPersistMovies() {

        em.getTransaction().begin();

        List<Genre> genres = tmdbService.getGenres();
        List<Genre> filteredGenres = genres.stream().filter(p -> p.getId() == 28 || p.getId() == 10749 || p.getId() == 878).collect(Collectors.toList());

        for (Genre genre : filteredGenres) {
            em.persist(genre);
        }
        em.getTransaction().commit();

        // tmdbService.getMoviesPerGenre();
        try {
            TestClass.getMoviesPerGenreNew();
        } catch (Exception e) {
        }

        /*
        Map<Genre, List<Movie>> movies = tmdbService.getMoviesPerGenre(filteredGenres);

        System.out.println("Persisting data to local DB...");

        em.getTransaction().begin();
        for (List<Movie> valueList : movies.values()) {
            for (Movie movie : valueList) {
                em.persist(movie);
            }
        }
        em.getTransaction().commit();
         */
        // Persist Genres
        //dbService.persistGenres(genres);
        // Persist Movies
        //dbService.persistMovies(movies);
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
