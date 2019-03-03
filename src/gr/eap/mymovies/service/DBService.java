package gr.eap.mymovies.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
public class DBService {

    private static final String PERSISTENCE_UNIT_NAME = "myMoviesPU";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    // minima apotixias syndesis sti bash
    private static final String errDBConn = "Αποτυχία σύνδεσης με τη Βάση Δεδομένων!";

    public static void connect() {
        if (emf == null) {
            try {
                //dimiourgia tou Entity Manager
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                em = emf.createEntityManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, errDBConn, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static EntityManager getEm() {
        return em;
    }
}
