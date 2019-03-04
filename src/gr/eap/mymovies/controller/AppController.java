package gr.eap.mymovies.controller;

/*geniki klasi diaxeirisis twn entities*/
import javax.persistence.EntityManager;
import javax.persistence.Query;

import gr.eap.mymovies.service.DBService;

/*
 * @authors:
 * eGiorgakis
 * kKagialoglou
 * aKarafotis
 * aLenas
 */
// abstract klasi pou klironomoun oloi oi controllers
public abstract class AppController {

    //static gia na exoume ton idio entity manager se oli tin efarmogi
    protected static EntityManager em;

    public AppController() {
        if (em == null) {
            /*syndesi me ti vasi, create entity factory kai entity manager*/
            DBService.connect();
            em = DBService.getEm();
        }
    }

    //methodos gia diagrafi pinaka mesw namedQuery.
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
