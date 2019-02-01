package gr.eap.mymovies.controller;

import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;

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

    @Override
    public void clearTable() {
        clearTbl("FavoriteList.deleteAll");
    }
}
