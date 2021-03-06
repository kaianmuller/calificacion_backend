package com.prueba_tecnica.calificacion_backend.dtos;

import com.prueba_tecnica.calificacion_backend.entities.Calificacion;

public class CalificacionDto {

    private Long id;
    private String nombre;
    private String correo;
    private Integer puntaje;
    private String observaciones;
    private String empresa;
    private Long telefono;
    
    public CalificacionDto() {
    }

    public CalificacionDto(Calificacion calificacion) {
        this.id = calificacion.getId();
        this.nombre = calificacion.getNombre();
        this.correo = calificacion.getCorreo();
        this.puntaje = calificacion.getPuntaje();
        this.observaciones = calificacion.getObservaciones();
        this.empresa = calificacion.getEmpresa();
        this.telefono = calificacion.getTelefono();
    }

    public CalificacionDto(Long id, String nombre, String correo, Integer puntaje, String observaciones,String empresa, Long telefono) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setPuntaje(puntaje);
        this.setObservaciones(observaciones);
        this.setEmpresa(empresa);
        this.setTelefono(telefono);
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
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
