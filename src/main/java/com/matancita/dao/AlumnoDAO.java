package com.matancita.dao;

import com.matancita.domain.Alumno;
import java.util.List;
import javax.persistence.*;



public class AlumnoDAO{
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public AlumnoDAO(){
        emf= Persistence.createEntityManagerFactory("HibernateJpaPU");
        em= emf.createEntityManager();
    }
    
    public List<Alumno> listarAlumno(){
        String hql = "SELECT a FROM Alumno a";
        Query query = em.createQuery(hql);
        List<Alumno> alumnos = query.getResultList();
        return alumnos;
    }
    
    public void insertarAlumno(Alumno alumno){
        try{
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }    
    }
    
    public Alumno encontrarAlumnoPorId(Alumno alumno){    
        Alumno a = em.find(Alumno.class, alumno.getIdAlumno());
        return a;     
    }
    
    public void modificarAlumno(Alumno alumno){
        
        try{
        em.getTransaction().begin();
        em.merge(alumno);
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }
        
    }
    
    public void eliminarAlumno(Alumno alumno){
         try{
        em.getTransaction().begin();
        em.remove(em.merge(alumno));
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }finally{
            if(em!=null){
                em.close();
            }
        }
    }
    
    
    
}
