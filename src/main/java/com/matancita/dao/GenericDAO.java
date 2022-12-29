/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matancita.dao;

import javax.persistence.*;

/**
 *
 * @author manue
 */
public abstract class GenericDAO {
    
    protected EntityManagerFactory emf;
    protected static EntityManager em;
    private static final String PU = "HibernateJpaPU";
    
    public GenericDAO(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em==null){
            em= emf.createEntityManager();
        }
        
        return em;
    }
    
}
