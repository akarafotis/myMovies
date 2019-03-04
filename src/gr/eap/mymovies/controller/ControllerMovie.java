package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.FavoriteList;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.service.TMBDService;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class ControllerMovie extends AppController {

    private final TMBDService tmdbService;

    public ControllerMovie() {
        super();

        // Initializing service
        tmdbService = new TMBDService();
    }

    // methodos gia eisagwgi dedomenvn ston pinaka Movies
    public void retrieveAndPersistMovies() throws IOException, ParseException {
        em.getTransaction().begin();
        ArrayList<Movie> movies = tmdbService.getMoviesPerGenre();
        ArrayList<Integer> keys = new ArrayList<>();
        em.persist(movies.get(0));
        keys.add(0, movies.get(0).getId());

        for (int i = 1; i < movies.size(); i++) {
            // elegxos an yparxei tainia me idio primary key (id)
            if (!keys.contains(movies.get(i).getId())) {
                keys.add(i, movies.get(i).getId());
                em.persist(movies.get(i));
            } else {
                keys.add(i, -800 + i);
            }
        }
        em.getTransaction().commit();
    }

    // methodos gia update tainias se periptosi pou allaksei h FavoriteList tis
    public void updateMovie(Movie movie, FavoriteList fl) throws IOException, ParseException {
        Movie m = em.find(Movie.class, movie.getId());
        em.getTransaction().begin();
        movie.setFavoriteListId(fl);
        em.getTransaction().commit();
    }

    // methodos gia anazitisi tainias vasei genre & year
    // me xrisi NamedQuery tis Movie class
    public List<Movie> searchMovies(String genre, String year) {
        Query q = em.createNamedQuery("Movie.findByYearAndGenre");
        q.setParameter("genre", genre);
        q.setParameter("releaseDate", Integer.parseInt(year));
        return q.getResultList();
    }

    // methodos gia anazitisi tainias vasei title
    // me xrisi NamedQuery tis Movie class
    public List<Movie> selectMovie(String title) {
        Query q = em.createNamedQuery("Movie.findByTitle");
        q.setParameter("title", title);
        return q.getResultList();
    }

    // methodos gia anazitisi tainias vasei FavoriteList
    // me xrisi NamedQuery tis Movie class
    public List<Movie> selectMovieByFavoriteList(FavoriteList favoriteList) {
        Query q = em.createNamedQuery("Movie.findByFavoriteList");
        q.setParameter("favoriteListId", favoriteList);
        return q.getResultList();
    }

    // methodos pou episrefei tis top10 tainies
    // me xrisi NamedQuery tis Movie class, thetontas MaxResults =10
    public List<Movie> findTop10Movies() {
        Query q = em.createNamedQuery("Movie.findTop10").setMaxResults(10);
        return q.getResultList();
    }

    // diagrafh twn eggrafwn apo to table Movie tis vasis
    @Override
    public void clearTable() {
        clearTbl("Movie.deleteAll");
    }
}
