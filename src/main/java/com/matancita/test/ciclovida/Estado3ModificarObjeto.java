package com.matancita.test.ciclovida;

import com.matancita.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manue
 */
public class Estado3ModificarObjeto {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Definimos la variable
        Contacto contacto = null;
        //recuperamos el objeto
        contacto = em.find(Contacto.class, 3);
        //modificamos el email
        contacto.setEmail("sarante4@mail.com");
        //iniciamos la transaccion
        em.getTransaction().begin();
        //realizamos a modificacion
        em.merge(contacto);
        //cerramos la transaccion
        em.getTransaction().commit();
        
        System.out.println("contacto = " + contacto);
        
        
    }
    
}
