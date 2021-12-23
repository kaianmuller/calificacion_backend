package com.prueba_tecnica.calificacion_backend.repositories;



import com.prueba_tecnica.calificacion_backend.models.Calificacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends CrudRepository<Calificacion, Long>{
    
}
