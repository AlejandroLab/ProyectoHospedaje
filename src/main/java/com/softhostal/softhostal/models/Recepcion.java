/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author maria
 */
@Entity
@Table(name = "recepciones")
public class Recepcion implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (name="estado")
    private String estado;
    @Column (name="fechaentra")
    private Date fechaentra;
    @Column (name="fechasalida")
    private Date fechasalida;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
     @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Override
    public String toString() {
        return "Recepcion{" + "id=" + id + ", estado=" + estado + ", fechaentra=" + fechaentra + ", fechasalida=" + fechasalida + ", producto=" + producto + ", cliente=" + cliente + '}';
    }

    public Recepcion(Long id, String estado, Date fechaentra, Date fechasalida, Producto producto, Cliente cliente) {
        this.id = id;
        this.estado = estado;
        this.fechaentra = fechaentra;
        this.fechasalida = fechasalida;
        this.producto = producto;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaentra() {
        return fechaentra;
    }

    public void setFechaentra(Date fechaentra) {
        this.fechaentra = fechaentra;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Recepcion() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Recepcion)) {
            return false;
        }
        Recepcion other = (Recepcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    


}
