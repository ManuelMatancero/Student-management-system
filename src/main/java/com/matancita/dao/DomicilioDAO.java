package com.matancita.dao;

import com.matancita.domain.Domicilio;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author manue
 */
public class DomicilioDAO extends GenericDAO {

//    EntityManagerFactory emf;
//    EntityManager em;
//    
//    public DomicilioDAO(){
//        emf= Persistence.createEntityManagerFactory("HibernateJpaPU");
//        em= emf.createEntityManager();
//    }
//    
    public List<Domicilio> listarDomicilio() {
        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Domicilio> domicilios = query.getResultList();
        return domicilios;
    }

    public void insertarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Domicilio encontrarDomicilioPorId(Domicilio domicilio) {
        em = getEntityManager();
        Domicilio a = em.find(Domicilio.class, domicilio.getIdDomicilio());
        return a;
    }

    public void modificarDomicilio(Domicilio domicilio) {

      try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void eliminarDomicilio(Domicilio domicilio) {
       try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
