package com.prueba_tecnica.calificacion_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;
import com.prueba_tecnica.calificacion_backend.entities.Usuario;
import com.prueba_tecnica.calificacion_backend.repositories.UsuarioRepository;
import com.prueba_tecnica.calificacion_backend.shared.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service()
public class UsuarioService implements UserDetailsService{

    @Autowired()
    UsuarioRepository usuarioRepository;

    private static final Log logger = LogFactory.getLog(CalificacionService.class);


    public UsuarioService(){
    }

    public ArrayList<UsuarioDto> getAll(){
        logger.info("GET USUARIO LIST");
        return (ArrayList<UsuarioDto>) Utils.convertArrayUsuariosToDto((List<Usuario>) usuarioRepository.findAll());
    }

    public Usuario findUsuarioByUsername(String username){
        return  usuarioRepository.findByUsername(username);
    }



    public boolean createOne(UsuarioDto usuarioDto){
        try {
               Usuario usuario = new Usuario(usuarioDto);
               usuarioRepository.save(usuario);
               logger.info("USUARIO CREADO");
               return true;
        } catch (Exception e) {
            logger.error("ERROR", e);
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
            logger.info("USUARIO MODIFICADO");
            return true;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return false;
        }
    }

    public boolean deleteOne(Long id){
        try {
            if(id != 0){
            usuarioRepository.deleteById(id);
            logger.info("USUARIO ELIMINADO");
            return true;
             }
             return false;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = findUsuarioByUsername(username);
        return new User(u.getUsername(),u.getPassword(),new ArrayList<>());
    }
    
}
