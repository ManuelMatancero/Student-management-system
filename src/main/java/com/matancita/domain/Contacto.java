package com.matancita.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author manue
 */
@Entity
@Table(name="contacto")
public class Contacto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_contacto")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idContacto;
    
    private String telefono;
    
    private String email;
    
    public Contacto(){
        
    }
    
    public Contacto(Integer idContacto){
        this.idContacto = idContacto;
    }

    public Contacto(String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
    }
    

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" + "idContacto=" + idContacto + ", telefono=" + telefono + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idContacto);
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
        final Contacto other = (Contacto) obj;
        return Objects.equals(this.idContacto, other.idContacto);
    }
    
    
    
}
