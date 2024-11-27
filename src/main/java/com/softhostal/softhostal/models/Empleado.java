/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author maria
 * 
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
      @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona idpersona;
    @Column(name = "salario")
    private int salario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "numerotelefonico")
    private int numerotelefonico;

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", idpersona=" + idpersona + ", salario=" + salario + ", correo=" + correo + ", cargo=" + cargo + ", numerotelefonico=" + numerotelefonico + '}';
    }

public Empleado() {
    }

    public Empleado(Long id, Persona idpersona, int salario, String correo, String cargo, int numerotelefonico) {
        this.id = id;
        this.idpersona = idpersona;
        this.salario = salario;
        this.correo = correo;
        this.cargo = cargo;
        this.numerotelefonico = numerotelefonico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getNumerotelefonico() {
        return numerotelefonico;
    }

    public void setNumerotelefonico(int numerotelefonico) {
        this.numerotelefonico = numerotelefonico;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
