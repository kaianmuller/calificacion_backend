package com.prueba_tecnica.calificacion_backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prueba_tecnica.calificacion_backend.dtos.CalificacionDto;


@Entity()
@Table(name = "calificaciones")
public class Calificacion implements Serializable{

    @Id()
    @GeneratedValue()
    @Column(name = "ID", unique = true,nullable = false)
    private Long id;

    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "CORREO",nullable = false)
    private String correo;

    @Column(name = "PUNTAJE",nullable = false)
    private Integer puntaje;

    @Column(name = "OBSERVACIONES",nullable = true)
    private String observaciones;

    @Column(name = "EMPRESA", nullable = true)
    private String empresa;

    @Column(name = "TELEFONO",nullable = true)
    private Integer telefono;
    
    public Calificacion() {
    }

    public Calificacion(CalificacionDto calificacionDto) {
        this.id = calificacionDto.getId();
        this.nombre = calificacionDto.getNombre();
        this.correo = calificacionDto.getCorreo();
        this.puntaje = calificacionDto.getPuntaje();
        this.observaciones = calificacionDto.getObservaciones();
        this.empresa = calificacionDto.getEmpresa();
        this.telefono = calificacionDto.getTelefono();
    }

    public Calificacion(Long id, String nombre, String correo, Integer puntaje, String observaciones, String empresa, Integer telefono) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setPuntaje(puntaje);
        this.setObservaciones(observaciones);
        this.setEmpresa(empresa);
        this.setTelefono(telefono);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
