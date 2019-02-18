package gr.eap.mymovies.controller;

/*γενική κλάση διαχείρησης των entities*/
import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.eap.mymovies.service.DBService;

/**
 *
 * @author akarafotis
 */
public abstract class AppController {

    //χρησιμοποιούμε static για να έχουμε τον ίδιο entity manager καθ' όλη τη διάρκεια της εκτέλεσης
    protected static EntityManager em;

    public AppController() {
        if (em == null) {
            /*Σύνδεση με τη βάση, δημιουργία entity factory και entity manager*/
            DBService.connect();
            em = DBService.getEm();
        }
    }

    //μέθοδος διαγραφής πίνακα μέσω ενός έτοιμου namedQuery.
    protected void clearTbl(String namedQuery) {
        try {
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery(namedQuery);
            query1.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    protected abstract void clearTable();
}
