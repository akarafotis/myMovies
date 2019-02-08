package gr.eap.mymovies.controller;

import gr.eap.mymovies.service.DBService;
import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.util.MoviesHelper;
import gr.eap.mymovies.model.Genre;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Query;

/**
 *
 * @author akarafotis
 */
public class ControllerGenre extends AppController {

    private final DBService dbService;
    private final TMBDService tmdbService;
    private final MoviesHelper moviesHelper;

    public ControllerGenre() {
        super();

        // Initializing services
        tmdbService = new TMBDService();
        dbService = new DBService();
        moviesHelper = new MoviesHelper();
    }

    @Override
    public void clearTable() {
        clearTbl("Genre.deleteAll");
    }

    // Εισαγωγή δεδομένων από JSON στον πίνακα Genres
    public void retrieveAndPersistGenres() throws IOException {

        em.getTransaction().begin();
        List<Genre> genres = tmdbService.getGenres();
        for (Genre genre : genres) {
            em.persist(genre);
            System.out.println("Inserted Genre: " + genre.getId());
        }
        em.getTransaction().commit();
    }

}
