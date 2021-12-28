package com.prueba_tecnica.calificacion_backend.repositories;



import java.io.Serializable;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.entities.Calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CalificacionRepository extends JpaRepository<Calificacion, Serializable>{
    public abstract Optional<Calificacion> findByCorreo(String correo);
}
