package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.dtos.CalificacionDto;
import com.prueba_tecnica.calificacion_backend.entities.Calificacion;
import com.prueba_tecnica.calificacion_backend.repositories.CalificacionRepository;
import com.prueba_tecnica.calificacion_backend.shared.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service()
public class CalificacionService {
    
    @Autowired()
    CalificacionRepository calificacionRepository;


    private static final Log logger = LogFactory.getLog(CalificacionService.class);



    public Long getCount(){
        logger.info("GET CALIFICACION COUNT");
        return  calificacionRepository.count();
    }

    public Long getMean(){
        logger.info("GET CALIFICACION MEAN");
        List<Calificacion> list = (List<Calificacion>) calificacionRepository.findAll();
        Long suma = 0L;
        for(Calificacion c: list){
        suma+=c.getPuntaje();
        }
        return suma/getCount();
    }


    public ArrayList<CalificacionDto> getAll(){
        logger.info("GET CALIFICACION LIST");
        return (ArrayList<CalificacionDto>) Utils.convertArrayCalificacionesToDto((List<Calificacion>) calificacionRepository.findAll());
    }

    public ArrayList<CalificacionDto> getAllWithPagination(Pageable pageable){
        logger.info("GET CALIFICACION LIST WITH PAGINATION");
        return (ArrayList<CalificacionDto>) Utils.convertArrayCalificacionesToDto((List<Calificacion>) calificacionRepository.findAll(pageable).getContent());
    }

    public boolean existCalificacionByCorreo(String correo){
        logger.info("VERIFY CALIFICATION BY CORREO");
        Optional<Calificacion> calific = calificacionRepository.findByCorreo(correo);
        if(!calific.isPresent()){
            return false;
        }
        return true;
    }


    public boolean createOne(CalificacionDto calificacionDto){
        try {
               Calificacion calificacion = new Calificacion(calificacionDto);
               calificacionRepository.save(calificacion);
               logger.info("CALIFICACION CREADA");
               return true;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return false;
        }
     
    }


    public boolean editOne(Long id, CalificacionDto calificacionDto){
  

        try {
        Calificacion calificacion = new Calificacion(calificacionDto);
        Optional<Calificacion> calific = calificacionRepository.findById(id);
        if(!calific.isPresent()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elemento no encontrado"
              );
        }
            calificacionRepository.save(calificacion);
            logger.info("CALIFICACION MODIFICADA");
            return true;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return false;
        }
    }

    public boolean deleteOne(Long id){
        

        try {
            if(id != 0){
            calificacionRepository.deleteById(id);
            logger.info("CALIFICACION ELIMINADA");
            return true;
             }
             return false;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return false;
        }
    }

}
