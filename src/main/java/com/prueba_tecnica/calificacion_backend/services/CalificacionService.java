package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;

import com.prueba_tecnica.calificacion_backend.models.Calificacion;
import com.prueba_tecnica.calificacion_backend.repositories.CalificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class CalificacionService {
    
    @Autowired()
    CalificacionRepository calificacionRepository;

    public ArrayList<Calificacion> getAll(){
        return (ArrayList<Calificacion>) calificacionRepository.findAll();
    }

    public Calificacion createOne(Calificacion calificacion){
        return calificacionRepository.save(calificacion);
    }
}
