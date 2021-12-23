package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.models.Calificacion;
import com.prueba_tecnica.calificacion_backend.repositories.CalificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


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


    public Calificacion editOne(Long id, Calificacion calificacion){
        Optional<Calificacion> calific = calificacionRepository.findById(id);
        if(!calific.isPresent()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elemento no encontrado"
              );
        }

        return calificacionRepository.save(calificacion);
    }

    public boolean deleteOne(Long id){
        if(id != 0){
            calificacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
