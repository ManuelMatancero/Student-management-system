package com.matancita.dao;

import com.matancita.domain.Alumno;
import java.util.List;
import javax.persistence.*;
import com.matancita.domain.Contacto;

/**
 *
 * @author manue
 */
public class ContactoDAO extends GenericDAO {

//     EntityManagerFactory emf;
//    EntityManager em;
//    
//    public ContactoDAO(){
//        emf= Persistence.createEntityManagerFactory("HibernateJpaPU");
//        em= emf.createEntityManager();
//    }
    public List<Contacto> listarContacto() {
        String hql = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Contacto> contactos = query.getResultList();
        return contactos;
    }

    public void insertarContacto(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }
    }

    public Contacto encontrarContactoPorId(Contacto contacto) {
        em = getEntityManager();
        Contacto a = em.find(Contacto.class, contacto.getIdContacto());
        return a;
    }

    public void modificarContacto(Contacto contacto) {

       try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }

    }

    public void eliminarContacto(Contacto contacto) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }
    }

}
