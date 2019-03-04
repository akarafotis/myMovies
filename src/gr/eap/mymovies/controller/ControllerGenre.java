package gr.eap.mymovies.controller;

import gr.eap.mymovies.service.TMBDService;
import gr.eap.mymovies.model.Genre;
import java.io.IOException;
import java.util.List;
import javax.persistence.Query;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class ControllerGenre extends AppController {

    private final TMBDService tmdbService;

    public ControllerGenre() {
        super();

        // Initializing service
        tmdbService = new TMBDService();
    }

    // methodos gia eisagwgi dedomenvn ston pinaka Genres
    public void retrieveAndPersistGenres() throws IOException {
        em.getTransaction().begin();
        List<Genre> genres = tmdbService.getGenres();
        for (Genre genre : genres) {
            em.persist(genre);
            System.out.println("Inserted Genre: " + genre.getId());
        }
        em.getTransaction().commit();
    }

    // methodos pou epistrefei ola ta Genres
    // me xrisi NamedQuery tis Genre class
    public List<Genre> findAll() {
        Query q = em.createNamedQuery("Genre.findAll");
        return q.getResultList();
    }

    // diagrafh twn eggrafwn apo to table Genre tis vasis
    @Override
    public void clearTable() {
        clearTbl("Genre.deleteAll");
    }
}
