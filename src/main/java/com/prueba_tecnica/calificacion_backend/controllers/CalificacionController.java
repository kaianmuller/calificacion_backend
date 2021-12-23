package com.prueba_tecnica.calificacion_backend.controllers;

import java.util.ArrayList;

import com.prueba_tecnica.calificacion_backend.models.Calificacion;
import com.prueba_tecnica.calificacion_backend.services.CalificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired()
    CalificacionService calificacionService;
    

    @GetMapping()
    public ArrayList<Calificacion> getAll(){
        return (ArrayList<Calificacion>) calificacionService.getAll();
    }

    @PostMapping()
    public Calificacion createOne(@RequestBody() Calificacion calificacion){
        return calificacionService.createOne(calificacion);
    }
}
