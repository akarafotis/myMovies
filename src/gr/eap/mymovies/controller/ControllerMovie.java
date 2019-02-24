package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.FavoriteList;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author akarafotis
 */
public class ControllerMovie extends AppController {

    private final DBService dbService;
    private final TMBDService tmdbService;

    public ControllerMovie() {
        super();

        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
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
        em.getTransaction().commit();
    }

    public void updateMovie(Movie movie, FavoriteList fl) throws IOException, ParseException {

        Movie m = em.find(Movie.class, movie.getId());
        em.getTransaction().begin();
        movie.setFavoriteListId(fl);
        em.getTransaction().commit();
    }

    public List<Movie> searchMovies(String genre, String year) {
        Query q = em.createNamedQuery("Movie.findByYear");
        q.setParameter("genre", genre);
        q.setParameter("releaseDate", Integer.parseInt(year));
        return q.getResultList();
    }

    public List<Movie> selectMovie(String title) {
        Query q = em.createNamedQuery("Movie.findByTitle");
        q.setParameter("title", title);
        return q.getResultList();
    }

    public List<Movie> selectMovieByFavoriteList(FavoriteList favoriteList) {
        Query q = em.createNamedQuery("Movie.findByFavoriteList");
        q.setParameter("favoriteListId", favoriteList);
        return q.getResultList();
    }

    public List<Movie> findTop10Movies() {
        Query q = em.createNamedQuery("Movie.findTop10").setMaxResults(10);
        return q.getResultList();
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
