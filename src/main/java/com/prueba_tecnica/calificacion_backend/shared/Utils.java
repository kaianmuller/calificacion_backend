package com.prueba_tecnica.calificacion_backend.shared;


import java.util.ArrayList;
import java.util.List;

import com.prueba_tecnica.calificacion_backend.dtos.CalificacionDto;
import com.prueba_tecnica.calificacion_backend.dtos.UsuarioDto;
import com.prueba_tecnica.calificacion_backend.entities.Calificacion;
import com.prueba_tecnica.calificacion_backend.entities.Usuario;

public class Utils{
    
   
    public static List<Usuario> convertArrayUsuariosToEntity(List<UsuarioDto> usuariosDto){
        List<Usuario> users = new ArrayList<Usuario>();
        for(UsuarioDto userDto: usuariosDto){
            users.add(new Usuario(userDto));
        }
        return users;
    }

  
    public static List<UsuarioDto> convertArrayUsuariosToDto(List<Usuario> usuarios){
        List<UsuarioDto> usersDto = new ArrayList<UsuarioDto>();
        for(Usuario user: usuarios){
            usersDto.add(new UsuarioDto(user));
        }
        return usersDto;
    }
    
   
    public static List<Calificacion> convertArrayCalificacionesToEntity(List<CalificacionDto> calificacionesDto){
        List<Calificacion> calificaciones = new ArrayList<Calificacion>();
        for(CalificacionDto calificacionDto: calificacionesDto){
            calificaciones.add(new Calificacion(calificacionDto));
        }
        return calificaciones;
    }

    
    public static List<CalificacionDto> convertArrayCalificacionesToDto(List<Calificacion> calificaciones){
        List<CalificacionDto> calificacionesDto = new ArrayList<CalificacionDto>();
        for(Calificacion calificacion: calificaciones){
            calificacionesDto.add(new CalificacionDto(calificacion));
        }
        return calificacionesDto;
    }

}
