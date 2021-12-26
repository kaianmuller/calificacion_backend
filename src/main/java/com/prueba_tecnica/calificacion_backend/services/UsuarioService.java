package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;
import com.prueba_tecnica.calificacion_backend.entities.Usuario;
import com.prueba_tecnica.calificacion_backend.repositories.UsuarioRepository;
import com.prueba_tecnica.calificacion_backend.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service()
public class UsuarioService {

    @Autowired()
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioDto> getAll(){
        return (ArrayList<UsuarioDto>) Utils.convertArrayUsuariosToDto((List<Usuario>) usuarioRepository.findAll());
    }

    public boolean createOne(UsuarioDto usuarioDto){
        try {
               Usuario usuario = new Usuario(usuarioDto);
               usuarioRepository.save(usuario);
               return true;
        } catch (Exception e) {
            return false;
        }
     
    }


    public boolean editOne(Long id, UsuarioDto usuarioDto){
  

        try {
        Usuario usuario = new Usuario(usuarioDto);
        Optional<Usuario> user = usuarioRepository.findById(id);
        if(!user.isPresent()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Elemento no encontrado"
              );
        }
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteOne(Long id){
        

        try {
            if(id != 0){
            usuarioRepository.deleteById(id);
            return true;
             }
             return false;
        } catch (Exception e) {
            return false;
        }
    }
    
}
