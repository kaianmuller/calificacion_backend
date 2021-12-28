package com.prueba_tecnica.calificacion_backend.controllers;

import java.util.ArrayList;

import com.prueba_tecnica.calificacion_backend.dtos.CalificacionDto;
import com.prueba_tecnica.calificacion_backend.services.CalificacionService;

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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("v1/calificaciones")
public class CalificacionController {

    @Autowired()
    CalificacionService calificacionService;
    
    @GetMapping()
    public ArrayList<CalificacionDto> getAll(){
        return  calificacionService.getAll();
    }

    @GetMapping("/existCalificacionByCorreo/{correo}")
    public boolean existCalificacionByCorreo(@PathVariable(name = "correo") String correo){
        return  calificacionService.existCalificacionByCorreo(correo);
    }

    @GetMapping("/count")
    public Long getCount(){
        return  calificacionService.getCount();
    }

    @PostMapping()
    public boolean createOne(@RequestBody() CalificacionDto calificacionDto){
        return calificacionService.createOne(calificacionDto);
    }

    @PutMapping("/{id}")
    public boolean editOne(@PathVariable(name = "id") Long id, @RequestBody() CalificacionDto calificacionDto){
        return calificacionService.editOne(id,calificacionDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOne(@PathVariable(name = "id") Long id){
        return calificacionService.deleteOne(id);
    }
}
