package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.models.Usuario;
import com.prueba_tecnica.calificacion_backend.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class UsuarioService {

    @Autowired()
    UsuarioRepository usuarioRepository;

    public ArrayList<Usuario> getAll(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario createOne(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    public Usuario editOne(Long id, Usuario usuario){
        Optional<Usuario> user = usuarioRepository.findById(id);
        if(!user.isPresent()){
            throw new UnsupportedOperationException();
        }

        return usuarioRepository.save(usuario);
    }
    
}
