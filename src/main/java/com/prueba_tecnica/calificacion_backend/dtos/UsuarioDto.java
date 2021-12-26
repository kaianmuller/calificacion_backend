package com.prueba_tecnica.calificacion_backend.dtos;

import com.prueba_tecnica.calificacion_backend.entities.Usuario;

public class UsuarioDto {
    
    private Long id;
    private String nombre;
    private String username;
    private String password;


    public UsuarioDto() {
    }

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.username = usuario.getUsername();
    }

    public UsuarioDto(Long id, String nombre, String username, String password) {
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
