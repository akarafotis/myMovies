package gr.eap.mymovies.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import gr.eap.mymovies.model.Genre;
import gr.eap.mymovies.model.Movie;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 *
 * @author akarafotis
 */
public class DBService {

    private static final String PERSISTENCE_UNIT_NAME = "myMoviesPU";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    //Μηνύματα
    private static final String errDBConn = "Αποτυχία σύνδεσης με τη Βάση Δεδομένων!";

    public static void connect() {
        if (emf == null) {
            try {
                //δημιουργία Entity Manager που θα χρησιμοποιηθεί καθ όλη τη διάρκεια εκτέλεσης της εφαρμογής.
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                em = emf.createEntityManager();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, errDBConn, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static EntityManager getEm() {
        return em;
    }

    public void persistGenres(List<Genre> genres) {

    }

    public void persistMovies(Map<Genre, List<Movie>> movies) {

    }

}
