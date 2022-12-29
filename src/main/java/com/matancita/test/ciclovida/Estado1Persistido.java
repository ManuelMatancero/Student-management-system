package com.matancita.test.ciclovida;

import com.matancita.dao.GenericDAO;
import com.matancita.domain.*;
import javax.persistence.*;

public class Estado1Persistido {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Estado transitivo
        Contacto con = new Contacto();
        con.setEmail("marc@mail.com");
        con.setTelefono("12321223");
        
        //2. Iniciamos la transaccion y persistimos
        em.getTransaction().begin();
        
        em.persist(con);
        
        //3. terminamos la transaccion
        em.getTransaction().commit();
        
        System.out.println("Contacto " + con);
        
        
        
    }
    
}
