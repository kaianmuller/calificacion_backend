package com.prueba_tecnica.calificacion_backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name = "calificaciones")
public class Calificacion {

    @Id()
    @GeneratedValue()
    @Column(unique = true,nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Integer puntaje;

    @Column(nullable = true)
    private String observaciones;

    @Column(nullable = true)
    private Integer celular;
    
    public Calificacion() {
    }

    public Calificacion(Long id, String nombre, String correo, Integer puntaje, String observaciones, Integer celular) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setPuntaje(puntaje);
        this.setObservaciones(observaciones);
        this.setCelular(celular);
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
