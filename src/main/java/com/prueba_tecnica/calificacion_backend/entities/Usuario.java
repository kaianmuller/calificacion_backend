package com.prueba_tecnica.calificacion_backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity()
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    @Id()
    @GeneratedValue()
    @Column(name = "ID",unique = true,nullable = false)
    private Long id;
    
    @Column(name = "NOMBRE",nullable = false)
    private String nombre;

    @Column(name = "USERNAME",nullable = false)
    private String username;

    @Column(name = "PASSWORD",nullable = false)
    private String password;


    public Usuario() {
    }

    public Usuario(UsuarioDto usuarioDto) {
        this.id = usuarioDto.getId();
        this.nombre = usuarioDto.getNombre();
        this.username = usuarioDto.getUsername();
        this.password = new BCryptPasswordEncoder().encode(usuarioDto.getPassword());
    }

    public Usuario(Long id, String nombre, String username, String password) {
        this.setId(id);
        this.setNombre(nombre);
        this.setUsername(username);
        this.setPassword(new BCryptPasswordEncoder().encode(password));
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
