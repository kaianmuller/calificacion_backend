package com.prueba_tecnica.calificacion_backend.repositories;



import java.io.Serializable;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.entities.Calificacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CalificacionRepository extends CrudRepository<Calificacion, Serializable>{
    public abstract Optional<Calificacion> findByCorreo(String correo);
}
