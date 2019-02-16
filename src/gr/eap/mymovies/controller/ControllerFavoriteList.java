package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.model.FavoriteList;
import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author akarafotis
 */
public class ControllerFavoriteList extends AppController {

    private final DBService dbService;
    private final TMBDService tmdbService;
    private final MoviesHelper moviesHelper;

    public ControllerFavoriteList() {
        super();

        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
        moviesHelper = new MoviesHelper();
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

    @Override
    public void clearTable() {
        clearTbl("FavoriteList.deleteAll");
    }
}
