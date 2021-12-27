package com.prueba_tecnica.calificacion_backend.controllers;

import java.util.ArrayList;

import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;
import com.prueba_tecnica.calificacion_backend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin()
@RequestMapping("v1/usuarios")
public class UsuarioController {

    @Autowired()
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioDto> getAll(){
        return  (ArrayList<UsuarioDto>) usuarioService.getAll();
    }

    @PostMapping()
    public boolean createOne(@RequestBody() UsuarioDto usuarioDto){
        return usuarioService.createOne(usuarioDto);

    }

    @PutMapping("/{id}")
    public boolean editOne(@PathVariable(name = "id") Long id, @RequestBody() UsuarioDto usuarioDto){
        return usuarioService.editOne(id,usuarioDto);
    }

    @DeleteMapping("/{id}")
    public boolean editOne(@PathVariable(name = "id") Long id){
        return usuarioService.deleteOne(id);
    }

}
