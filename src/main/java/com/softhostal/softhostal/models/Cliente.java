package com.softhostal.softhostal.models;

import jakarta.persistence.*;
import java.io.Serializable;
/**
 *
 * @author maria
 * 
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombres")    
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dni")
    private int dni;
    @Column(name = "numerotelefonico")
    private int numerotelefonico;
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNumerotelefonico() {
        return numerotelefonico;
    }

    public void setNumeroTelefonico(int numerotelefonico) {
        this.numerotelefonico = numerotelefonico;
    }

    
    
    
    public Cliente() {
    }
    
    public Cliente(Long id, String nombres, String apellidos,int dni,int numerotelefonico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni=dni;
        this.numerotelefonico=numerotelefonico;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", numerotelefonico=" + numerotelefonico + '}';
    }

    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    
}
