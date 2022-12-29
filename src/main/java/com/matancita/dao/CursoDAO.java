package com.matancita.dao;

import com.matancita.domain.Curso;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author manue
 */
public class CursoDAO extends GenericDAO {
       
//    EntityManagerFactory emf;
//    EntityManager em;
//    
//    public CursoDAO(){
//        emf= Persistence.createEntityManagerFactory("HibernateJpaPU");
//        em= emf.createEntityManager();
//    }
    
    public List<Curso> listarCurso(){
        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Curso> cursos = query.getResultList();
        return cursos;
    }
    
    public void insertarCurso(Curso curso){
        try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        } 
        finally{
            if(em!=null){
                em.close();
            }
        }
    }
    
    public Curso encontrarCursoPorId(Curso curso){   
        em = getEntityManager();
        Curso a = em.find(Curso.class, curso.getIdCurso());
        return a;     
    }
    
    public void modificarCurso(Curso curso){
        
         try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        } 
        finally{
            if(em!=null){
                em.close();
            }
        }
        
    }
    
    public void eliminarCurso(Curso curso){
          try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(curso));
        em.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        } 
        finally{
            if(em!=null){
                em.close();
            }
        }
    }
    
    
}
