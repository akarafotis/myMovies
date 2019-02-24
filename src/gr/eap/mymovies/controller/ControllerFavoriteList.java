package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.model.FavoriteList;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.controller.ControllerMovie;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author akarafotis
 */
public class ControllerFavoriteList extends AppController {

    private final DBService dbService;
    private final TMBDService tmdbService;
    private ControllerMovie controllerMovie;

    public ControllerFavoriteList() {
        super();

        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
        controllerMovie = new ControllerMovie();
    }

    public List<FavoriteList> selectFL(String name) {
        Query q = em.createNamedQuery("FavoriteList.findByName");
        q.setParameter("name", name);
        return q.getResultList();
    }

    public List<FavoriteList> findAll() {
        Query q = em.createNamedQuery("FavoriteList.findAll");
        return q.getResultList();
    }

    public FavoriteList findFavoriteListById(int favoriteListId) {
        return em.find(FavoriteList.class, favoriteListId);
    }

    public static void persistFavoriteList(String fl_name) {

        FavoriteList newFL = new FavoriteList();
        em.getTransaction().begin();
        newFL.setName(fl_name);
        em.persist(newFL);
        em.getTransaction().commit();
    }

    public void updateFavoriteList(FavoriteList list) {
        em.getTransaction().begin();
        em.persist(list);
        em.getTransaction().commit();
    }

    public void deleteFavoriteList(FavoriteList list) {

        em.getTransaction().begin();
        List<Movie> movies = controllerMovie.selectMovieByFavoriteList(list);
        movies.forEach(movie -> {
            movie.setFavoriteListId(null);
            em.persist(movie);
        });
        em.remove(list);
        em.getTransaction().commit();
    }

    public void deleteFavoriteLists(List<FavoriteList> lists) {
        lists.forEach(list -> deleteFavoriteList(list));
    }

    @Override
    public void clearTable() {
        clearTbl("FavoriteList.deleteAll");
    }
}
