package com.matancita.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;


@Entity
public class Alumno implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
     @Id
     @Column(name="id_alumno")
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer idAlumno;
     
     @JoinColumn(name="id_domicilio", referencedColumnName = "id_domicilio")
     @ManyToOne(cascade=CascadeType.ALL)//Esta configuracion me permite guardar al mismo tiempo los datos en la tabla de domicilio y se asociara a la tabla de alumno
     private Domicilio domicilio;
     
     
     @JoinColumn(name="id_contacto", referencedColumnName = "id_contacto")
     @ManyToOne(cascade=CascadeType.ALL)
     private Contacto contacto;
     
     private String nombre;
     
     private String apellido;
     
     @OneToMany(mappedBy= "idAlumno")
     private List<Asignacion> asignaciones;

    public Alumno() {
    }

    public Alumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Alumno(Domicilio domicilio, Contacto contacto, String nombre, String apellido) {
        this.domicilio = domicilio;
        this.contacto = contacto;
        this.nombre = nombre;
        this.apellido = apellido;
    }
     
    
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
    

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", Domicilio=" + domicilio + ", contacto=" + contacto + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idAlumno);
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
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.idAlumno, other.idAlumno);
    }
     
    
}
