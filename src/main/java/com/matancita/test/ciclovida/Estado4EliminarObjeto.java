/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matancita.test.ciclovida;

import com.matancita.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manue
 */
public class Estado4EliminarObjeto {
      public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Definimos la variable
        Contacto contacto = null;
        //recuperamos el objeto
        contacto = em.find(Contacto.class, 3);
  
        //iniciamos la transaccion
        em.getTransaction().begin();
        //realizamos la eliminacion
        em.remove(em.merge(contacto));
        //cerramos la transaccion
        em.getTransaction().commit();
        
        System.out.println("contacto = " + contacto);
        
        
    }
}
