package com.matancita.test.cascade;

import com.matancita.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manue
 */
public class PersistenciaCascadaTest {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Domicilio dom = new Domicilio();
        dom.setCalle("General Florimon");
        dom.setNoCalle("70");
        dom.setPais("Republica Dominicana");
        Contacto con = new Contacto();
        con.setEmail("ingre@mail.com");
        con.setTelefono("3245345235");
        
        Alumno alumn = new Alumno();  
        alumn.setNombre("Ingreni");
        alumn.setApellido("Sanchez");
        alumn.setDomicilio(dom);
        alumn.setContacto(con);
        
        //Iniciamos una transaccion
        em.getTransaction().begin();
        
        //Persistimos el objeto
        em.persist(alumn);
        
        //Terminamos la transaccion
        em.getTransaction().commit();
        
        //Detached imprimimos el objeto en estado de detached
        System.out.println("alumn = " + alumn);
        
    }
    
}
