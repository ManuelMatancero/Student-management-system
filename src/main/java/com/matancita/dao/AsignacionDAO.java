package com.matancita.dao;


import com.matancita.domain.Asignacion;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author manue
 */
public class AsignacionDAO extends GenericDAO {

//     EntityManagerFactory emf;
//    EntityManager em;
//    
//    public AsignacionDAO(){
//        emf= Persistence.createEntityManagerFactory("HibernateJpaPU");
//        em= emf.createEntityManager();
//    }
    public List<Asignacion> listarAsignacion() {
        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Asignacion> asignaciones = query.getResultList();
        return asignaciones;
    }

    public void insertarAsignacion(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public Asignacion encontrarAsignacionPorId(Asignacion asignacion) {
        em = getEntityManager();
        Asignacion a = em.find(Asignacion.class, asignacion.getIdAsignacion());
        return a;
    }

    public void modificarAsignacion(Asignacion asignacion) {

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void eliminarAsignacion(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
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
