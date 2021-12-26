package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.dtos.CalificacionDto;
import com.prueba_tecnica.calificacion_backend.entities.Calificacion;
import com.prueba_tecnica.calificacion_backend.repositories.CalificacionRepository;
import com.prueba_tecnica.calificacion_backend.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service()
public class CalificacionService {
    
    @Autowired()
    CalificacionRepository calificacionRepository;


    public ArrayList<CalificacionDto> getAll(){
        return (ArrayList<CalificacionDto>) Utils.convertArrayCalificacionesToDto((List<Calificacion>) calificacionRepository.findAll());
    }

    public boolean createOne(CalificacionDto calificacionDto){
        try {
               Calificacion calificacion = new Calificacion(calificacionDto);
               calificacionRepository.save(calificacion);
               return true;
        } catch (Exception e) {
            return false;
        }
     
    }


    public boolean editOne(Long id, CalificacionDto calificacionDto){
  

        try {
        Calificacion calificacion = new Calificacion(calificacionDto);
        Optional<Calificacion> user = calificacionRepository.findById(id);
        if(!user.isPresent()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elemento no encontrado"
              );
        }
            calificacionRepository.save(calificacion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteOne(Long id){
        

        try {
            if(id != 0){
            calificacionRepository.deleteById(id);
            return true;
             }
             return false;
        } catch (Exception e) {
            return false;
        }
    }

}
