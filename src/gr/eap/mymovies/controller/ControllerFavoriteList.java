package gr.eap.mymovies.controller;

import static gr.eap.mymovies.controller.AppController.em;
import gr.eap.mymovies.model.Movie;
import gr.eap.mymovies.model.FavoriteList;
import java.util.List;
import javax.persistence.Query;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class ControllerFavoriteList extends AppController {

    private ControllerMovie controllerMovie;

    public ControllerFavoriteList() {
        super();

        // arxikopoihisi controller
        controllerMovie = new ControllerMovie();
    }

    // methodos pou epistrefei tis FavoriteList vasei onomatos
    // me xrisi NamedQuery tis FavoriteList class
    public List<FavoriteList> selectFL(String name) {
        Query q = em.createNamedQuery("FavoriteList.findByName");
        q.setParameter("name", name);
        return q.getResultList();
    }

    // methodos pou epistrefei oles tis FavoriteList
    // me xrisi NamedQuery tis FavoriteList class
    public List<FavoriteList> findAll() {
        Query q = em.createNamedQuery("FavoriteList.findAll");
        return q.getResultList();
    }

    // methodos pou epistrefei tis FavoriteList vasei id
    // me xrisi NamedQuery tis FavoriteList class
    public FavoriteList findFavoriteListById(int favoriteListId) {
        return em.find(FavoriteList.class, favoriteListId);
    }

    // methodos pou eisagei FavoriteList stin vash
    public static void persistFavoriteList(String fl_name) {
        FavoriteList newFL = new FavoriteList();
        em.getTransaction().begin();
        newFL.setName(fl_name);
        em.persist(newFL);
        em.getTransaction().commit();
    }

    // methodos pou kanei update 1 FavoriteList stin vash
    public void updateFavoriteList(FavoriteList list) {
        em.getTransaction().begin();
        em.persist(list);
        em.getTransaction().commit();
    }

    // methodos pou diagrafei 1 FavoriteList stin vash
    public void deleteFavoriteList(FavoriteList list) {
        em.getTransaction().begin();
        // gia tis tainies pou anikouns stin FavoriteList
        // diatiroume tis tainies thetontas to FavoriteListId tous se null
        List<Movie> movies = controllerMovie.selectMovieByFavoriteList(list);
        movies.forEach(movie -> {
            movie.setFavoriteListId(null);
            em.persist(movie);
        });
        em.remove(list);
        em.getTransaction().commit();
    }

    // diagrafh twn eggrafwn apo to table FavoriteList tis vasis
    @Override
    public void clearTable() {
        clearTbl("FavoriteList.deleteAll");
    }
}
