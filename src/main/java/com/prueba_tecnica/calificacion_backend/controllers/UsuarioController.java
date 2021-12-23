package com.prueba_tecnica.calificacion_backend.controllers;

import java.util.ArrayList;

import com.prueba_tecnica.calificacion_backend.models.Usuario;
import com.prueba_tecnica.calificacion_backend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired()
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<Usuario> getAll(){
        return  (ArrayList<Usuario>) usuarioService.getAll();
    }

    @PostMapping()
    public Usuario createOne(@RequestBody() Usuario usuario){
        return usuarioService.createOne(usuario);
    }

    @PutMapping("/{id}")
    public Usuario editOne(@PathVariable(name = "id") Long id, @RequestBody() Usuario usuario){
        return usuarioService.editOne(id,usuario);
    }

    @DeleteMapping("/{id}")
    public boolean editOne(@PathVariable(name = "id") Long id){
        return usuarioService.deleteOne(id);
    }

}
