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
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "piso")
    private String piso;
   @Column(name = "numdehab")
    private int numdehab;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "caracteristica")
    private String caracteristica;
    @Column(name = "precio")
    private int precio;
    @Column(name = "disponibilidad")
    private boolean disponibilidad;
      public Habitacion(){
        
    }

    public Habitacion(Long id, String piso, int numdehab, String tipo, String caracteristica, int precio, boolean disponibilidad) {
        this.id = id;
        this.piso = piso;
        this.numdehab = numdehab;
        this.tipo = tipo;
        this.caracteristica = caracteristica;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }
    
    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
    public int getNumdehab() {
        return numdehab;
    }

    public void setNumdehab(int numdehab) {
        this.numdehab = numdehab;
    }

 
      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
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
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", piso=" + piso + ", numdehab=" + numdehab + ", tipo=" + tipo + ", caracteristica=" + caracteristica + ", precio=" + precio + ", disponibilidad=" + disponibilidad + '}';
    }
  
    
}
