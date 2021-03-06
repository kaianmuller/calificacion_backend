package com.prueba_tecnica.calificacion_backend.repositories;



import java.io.Serializable;

import com.prueba_tecnica.calificacion_backend.entities.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface UsuarioRepository extends CrudRepository<Usuario, Serializable>{

    public Usuario findByUsername(String username);

}
