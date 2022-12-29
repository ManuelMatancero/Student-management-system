package com.matancita.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author manue
 */
@Entity
public class Asignacion implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @Column(name="id_asignacion")
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer idAsignacion;
     
     @JoinColumn(name="id_alumno", referencedColumnName = "id_alumno")
     @ManyToOne
     private Alumno idAlumno;
     
     @JoinColumn(name="id_curso", referencedColumnName = "id_curso")
     @ManyToOne
     private Curso idCurso;
     
     private String turno;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "idAsignacion=" + idAsignacion + ", idAlumno=" + idAlumno + ", idCurso=" + idCurso + ", turno=" + turno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idAsignacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignacion other = (Asignacion) obj;
        return Objects.equals(this.idAsignacion, other.idAsignacion);
    }
     
     
     
     
     
}
