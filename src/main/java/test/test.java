package test;

import com.matancita.dao.AlumnoDAO;
import com.matancita.dao.AsignacionDAO;
import com.matancita.dao.*;
import com.matancita.domain.Alumno;
import com.matancita.domain.Asignacion;
import com.matancita.domain.*;
import com.matancita.domain.Curso;
import com.matancita.domain.Domicilio;
import java.util.List;

/**
 *
 * @author manue
 */
public class test {
    
    public static void main(String[] args) {
        
        AsignacionDAO Asignacion = new AsignacionDAO();
        
        List<Asignacion> Asignacions = Asignacion.listarAsignacion();
        
        for(Asignacion a: Asignacions)
        System.out.println("Asignacion: " + a);
        
       
              
        //alumno.insertarAlumno(a);
        
    }
    
}
