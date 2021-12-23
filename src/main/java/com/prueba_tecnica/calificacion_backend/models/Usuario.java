package com.prueba_tecnica.calificacion_backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "usuarios")
public class Usuario {
    
    @Id()
    @GeneratedValue()
    @Column(unique = true,nullable = false)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public Usuario(Long id, String nombre, String username, String password) {
        this.setId(id);
        this.setNombre(nombre);
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
